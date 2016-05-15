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
		//1. receiverId(MemberCode)�� �˶� ���� ��������
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");

		ArrayList<AlarmDTO> dto = (ArrayList<AlarmDTO>)dao.searchAlarmMemberCode(receiverId);
		//2. ���� �� Ÿ������ ��Ƶ� 

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
		//1. receiverId(MemberCode)�� �˶� ���� ��������
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
		//2. �˶� �޽��� �ڵ�� �˻�
		AlarmDTO dto = dao.searchAlarmCode(alarmMessageCode);
		//3. ���� �� Ÿ������ ��Ƶ�  / �ڵ� , �˸���¥, receiverId, �˶�����
		AlarmMessage alarmMessage = new AlarmMessage(dto.getAlarmCode(),dto.getArrivalDate(),dto.getMemberCode(),dto.getAlarmKindCode());

		return alarmMessage;
	}

	@Override
	public boolean alarmSharedFolderInvite(String senderId, String receiverId,String alarmKindName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		System.out.println(alarmKindName);
		//1. �˶����� �̸��� ���� �ڵ������� ������
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName(alarmKindName);//���������ʴ�
		System.out.println(alarmKindDto.get(0));
		
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
		System.out.println(""+receiverId+" "+alarmKindDto.get(0).getAlarmKindCode()+" "+senderId);
		
		//memberCode, �˶������ڵ�, ������� Code
			
		AlarmInsertDAO insertDao = (AlarmInsertDAO)factory.create("Alarm");
		////�˶�����, �޴»��Code, �����»��Code�� �ʴ� �˶� ����
		if(insertDao.insertAlarm(alarmKindDto.get(0).getAlarmKindCode(), receiverId, senderId)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean alarmFriendRequest(String alarmMessageName,String receiverId, String senderId) {
		//�޴»���ڵ� ��������ڵ�
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. �˶����� �̸��� ���� �ڵ������� ������
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName(alarmMessageName);
		//2. �˶��� �ִ� ���
		if(alarmKindDto.size() != 0)
		{
			System.out.println(alarmKindDto.get(0).getAlarmKindCode().trim());
			AlarmInsertDAO insertDao = (AlarmInsertDAO)factory.create("Alarm");
			////�˶�����, �޴»��Code, �����»��Code�� �ʴ� �˶� ����
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

		//1. �˶����� �̸��� ���� �ڵ������� ������
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName("ģ����û");//ģ�� ��û�̶� �̸��� ���� �ڵ� ������
		ArrayList<AlarmKindDTO> acceptKindDto = (ArrayList<AlarmKindDTO>)alarmKindSearchDao.searchAlarmKindName("ģ������");//ģ�������̶� �̸��� �����ڵ� ������

		//2. �˶��� �ִ� ���
		if(alarmKindDto != null)
		{
			String alarmKindCode = alarmKindDto.get(0).getAlarmKindCode().trim();		//�˶� ���� �ڵ�
			String acceptKindCode = acceptKindDto.get(0).getAlarmKindCode().trim();	//ģ������ �˶� ���� �ڵ�	

			//3. ���� ����ڿ� ��������� �ڵ�� �˶������� �����ϴ��� Ȯ��
			AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> acceptdto= (ArrayList<AlarmDTO>)dao.searchAlarmMemberKindSenderCode(receiverId, alarmKindCode, senderId);//memberCode, �˶������ڵ�, ������� Code

			if(acceptdto.size() != 0)
			{		
				//�˶��ڵ� ������
				String acceptCode = acceptdto.get(0).getAlarmCode();				

				//�˶��ڵ忡 ���� �������� ������Ʈ
				AlarmUpdateDAO updateDao = (AlarmUpdateDAO)factory.create("Alarm");	
				updateDao.updateAlarmKind(acceptCode,acceptKindCode);//119��° ��

				//���ο� �˶� ���� - �˶�����, �޴»��Code, �����»��Code�� �ʴ� �˶� ����
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
