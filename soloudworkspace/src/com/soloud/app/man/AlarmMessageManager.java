package com.soloud.app.man;

import java.util.ArrayList;

import com.soloud.app.model.AlarmMessage;
import com.soloud.per.dao.AlarmInsertDAO;
import com.soloud.per.dao.AlarmKindSearchDAO;
import com.soloud.per.dao.AlarmSearchDAO;
import com.soloud.per.dao.AlarmUpdateDAO;
import com.soloud.per.dto.AlarmDTO;
import com.soloud.per.dto.AlarmKindDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;


public class AlarmMessageManager extends AbstractAlarmMessageManager{

	@Override
	public ArrayList<AlarmMessage> searchAlarmReceiverId(String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. receiverId(MemberCode)로 알람 정보 가져오기
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");

		ArrayList<AlarmDTO> dto = (ArrayList<AlarmDTO>)dao.searchAlarmMemberCode(receiverId);
		//2. 리턴 할 타입으로 담아둠 

		ArrayList<AlarmMessage> alarmMessage = new ArrayList<AlarmMessage>();
		for(AlarmDTO alarm : dto)
		{
			alarmMessage.add(new AlarmMessage(alarm.getAlarmCode().trim(),alarm.getArrivalDate(),alarm.getSenderCode().trim(),alarm.getAlarmKindCode().trim(),alarm.getIsReadAlarm().trim()));
		}
		return alarmMessage;
	}
	
	@Override
	public AlarmMessage searchAlarmAlarmMessageCode(String alarmMessageCode) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. receiverId(MemberCode)로 알람 정보 가져오기
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
		//2. 알람 메시지 코드로 검색
		AlarmDTO dto = dao.searchAlarmCode(alarmMessageCode);
		//3. 리턴 할 타입으로 담아둠  / 코드 , 알림날짜, receiverId, 알람종류
		AlarmMessage alarmMessage = new AlarmMessage(dto.getAlarmCode(),dto.getArrivalDate(),dto.getMemberCode(),dto.getAlarmKindCode());

		return alarmMessage;
	}

	@Override
	public boolean alarmSharedFolderInvite(String senderId, String receiverId,String alarmKindName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		System.out.println(alarmKindName);
		//1. 알람유형 이름에 대한 코드정보를 가져옴
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName(alarmKindName);//공유폴더초대
		System.out.println(alarmKindDto.get(0));
		
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
		System.out.println(""+receiverId+" "+alarmKindDto.get(0).getAlarmKindCode()+" "+senderId);
		
		//memberCode, 알람유형코드, 보낸사람 Code
			
		AlarmInsertDAO insertDao = (AlarmInsertDAO)factory.create("Alarm");
		////알랑유형, 받는사람Code, 보내는사람Code로 초대 알람 생성
		if(insertDao.insertAlarm(alarmKindDto.get(0).getAlarmKindCode(), receiverId, senderId)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean alarmFriendRequest(String alarmMessageName,String receiverId, String senderId) {
		//받는사람코드 보낸사람코드
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. 알람유형 이름에 대한 코드정보를 가져옴
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName(alarmMessageName);
		//2. 알람이 있는 경우
		if(alarmKindDto.size() != 0)
		{
			System.out.println(alarmKindDto.get(0).getAlarmKindCode().trim());
			AlarmInsertDAO insertDao = (AlarmInsertDAO)factory.create("Alarm");
			////알랑유형, 받는사람Code, 보내는사람Code로 초대 알람 생성
			if(insertDao.insertAlarm(alarmKindDto.get(0).getAlarmKindCode().trim(), receiverId, senderId) != false)
			{
				return true;
			}else
				return false;			
		}
		return false;
	}

	@Override
	public boolean alarmFriendAccept(String senderId, String receiverId,String alarmKindName) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//1. 알람유형 이름에 대한 코드정보를 가져옴
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName("친구신청");//친구 신청이란 이름의 유형 코드 가져옴
		ArrayList<AlarmKindDTO> acceptKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName("친구수락");//친구수락이란 이름의 유형코드 가져옴

		//2. 알람이 있는 경우
		if(alarmKindDto != null)
		{
			String alarmKindCode = alarmKindDto.get(0).getAlarmKindCode().trim();		//알람 유형 코드
			String acceptKindCode = acceptKindDto.get(0).getAlarmKindCode().trim();	//친구수락 알람 유형 코드	

			//3. 현재 사용자와 보낸사용자 코드로 알람정보가 존재하는지 확인
			AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> acceptdto= (ArrayList<AlarmDTO>)dao.searchAlarmMemberKindSenderCode(receiverId, alarmKindCode, senderId);//memberCode, 알람유형코드, 보낸사람 Code

			if(acceptdto.size() != 0)
			{		
				//알람코드 가져옴
				String acceptCode = acceptdto.get(0).getAlarmCode();				

				//알람코드에 대해 수락으로 업데이트
				AlarmUpdateDAO updateDao = (AlarmUpdateDAO)factory.create("Alarm");	
				updateDao.updateAlarmKind(acceptCode,acceptKindCode);//119번째 줄

				//새로운 알람 생성 - 알랑유형, 받는사람Code, 보내는사람Code로 초대 알람 생성
				AlarmInsertDAO insertDao = (AlarmInsertDAO)factory.create("Alarm");
				if(insertDao.insertAlarm(acceptKindCode, senderId, receiverId) != false)
				{
					return true;
				}else{
					return false;
				}			
			}else
				return false;
		}
		
		return false;
	}

	@Override
	public boolean alarmTag(String senderId, ArrayList<String> receiverId,
			String alarmKindCode) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public int modifyAlarmNoReadChange(String alarmCode) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		AlarmUpdateDAO dao = (AlarmUpdateDAO)factory.create("Alarm");
		 
		return dao.updateAlarmIsRead(alarmCode);
	}

	

}
