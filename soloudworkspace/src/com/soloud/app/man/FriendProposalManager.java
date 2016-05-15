package com.soloud.app.man;
import java.util.ArrayList;
import java.util.List;

import com.soloud.app.manInt.AlarmMessageAlarmable;
import com.soloud.app.manInt.FriendSearchable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.AlarmMessage;
import com.soloud.app.model.Friend;
import com.soloud.app.model.FriendProposal;
import com.soloud.app.model.Member;
import com.soloud.per.dao.AlarmDeleteDAO;
import com.soloud.per.dao.AlarmKindSearchDAO;
import com.soloud.per.dao.AlarmSearchDAO;
import com.soloud.per.dao.MemberKindSearchDAO;
import com.soloud.per.dao.MemberSearchDAO;
import com.soloud.per.daoimpl.AlarmDAOImpl;
import com.soloud.per.daoimpl.MemberDAOImpl;
import com.soloud.per.dto.AlarmDTO;
import com.soloud.per.dto.AlarmKindDTO;
import com.soloud.per.dto.MemberDTO;
import com.soloud.per.dto.MemberKindDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;
public class FriendProposalManager extends AbstractFriendProposalManager{

	@Override
	public boolean cancelFriendProposal(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//senderId : 나 receiverId : 친구대상
		//1.친구대상이 존재하는지 확인
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(receiverId);
		if(member.getId() != null)
		{
			System.out.println("친구는 회원임");
			//친구 정보 검색
			MemberSearchDAO memberSearchDao = (MemberSearchDAO)factory.create("Member");
			MemberDTO memberInfo = memberSearchDao.searchMemberId(receiverId);
			System.out.println("친구 코드 : " +memberInfo.getMemberCode().trim());
			//2. 내가 제안 한 친구 신청이 있는지 확인
			FriendProposal friendProposal = searchFriendProposal(senderId, memberInfo.getMemberCode().trim());//나 친구대상
			if(friendProposal != null)
			{
				System.out.println("내가 제안한 신청이 있음");
				AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
				//여기서 알람 제안 유형에 알람 코드가 들어가있다.
				if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
				{
					System.out.println("친구신청취소성공");
					return true;
				}else{
					System.out.println("친구신청취소실패");
					return false;
				}
			}else{
				System.out.println("신청한 제안이 없음");
				return false;
			}
		}else{
			System.out.println("친구는 회원이 아님");
			return false;
		}
	}

	@Override
	public boolean cancelFriendProposal(String adminId, String senderId, String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1.관리자 아이디 여부 확인
		//세션으로 관리자 코드가 옴
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//관리자 멤버여부 확인

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("관리자아이디 회원검사 통과 ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//관리자 멤버유형코드 검색

			if(memberKindDto.getMemberKindName().trim().equals("관리자"))										//관리자 인 경우
			{
				//senderId : 나 receiverId : 친구대상
				//1.친구대상이 존재하는지 확인
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(receiverId);
				if(member.getId() != null)
				{
					System.out.println("친구는 회원임");
					//2. 내가 제안 한 친구 신청이 있는지 확인
					FriendProposal friendProposal = searchFriendProposal(senderId, receiverId);//나 친구대상
					if(friendProposal != null)
					{
						System.out.println("내가 제안한 신청이 있음");
						AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
						//여기서 알람 제안 유형에 알람 코드가 들어가있다.
						if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
						{
							System.out.println("친구신청취소성공");
							return true;
						}else{
							System.out.println("친구신청취소실패");
							return false;
						}
					}else{
						System.out.println("신청한 제안이 없음");
						return false;
					}
				}else{
					System.out.println("친구는 회원이 아님");
					return false;
				}
			}else{
				System.out.println("관리자가 아님 탈락");
				return false;
			}
		}else{
			System.out.println("관리자가 아님 탈락");
			return false;
		}
	}

	@Override
	public boolean refuseFriendProposal(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//senderId가 친구 receiverId가 현재 사용자
		//1.친구가 존재하는지 확인
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(senderId);
		if(member.getId() != null)
		{
			System.out.println("친구가 회원임");
			String friendCode = memberSearchable.searchMemberAdmin(senderId).trim();
			System.out.println("친구 코드 : " +friendCode);
			//2. 친구가 나에게 보낸 제안 확인
			FriendProposal friendProposal = searchFriendProposal(friendCode, receiverId);//친구 나
			if(friendProposal != null)
			{
				System.out.println("친구가 보낸 친구신청이 있음");
				AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
				//여기서 알람 제안 유형에 알람 코드가 들어가있다.
				if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
				{
					System.out.println("거절성공, 메시지 삭제");
					return true;
				}else{
					System.out.println("거절 실패 , 메시지 유지");
					return false;
				}
			}else{
				System.out.println("친구가보낸 친구신청이없음");
				return false;
			}
		}else{
			System.out.println("친구가 회원이 아님");
			return false;
		}
	}

	@Override
	public boolean refuseFriendProposal(String adminId, String senderId,String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1.관리자 아이디 여부 확인
		//세션으로 관리자 코드가 옴
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//관리자 멤버여부 확인

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("관리자아이디 회원검사 통과 ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//관리자 멤버유형코드 검색

			if(memberKindDto.getMemberKindName().trim().equals("관리자"))										//관리자 인 경우
			{
				//senderId가 친구 receiverId가 현재 사용자
				//1.친구가 존재하는지 확인
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(senderId);
				if(member != null)
				{
					System.out.println("친구가 회원임");
					//2. 친구가 나에게 보낸 제안 확인
					FriendProposal friendProposal = searchFriendProposal(senderId, receiverId);//친구 나
					if(friendProposal != null)
					{
						System.out.println("친구가 보낸 친구신청이 있음");
						AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
						//여기서 알람 제안 유형에 알람 코드가 들어가있다.
						if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
						{
							System.out.println("거절성공, 메시지 삭제");
							return true;
						}else{
							System.out.println("거절 실패 , 메시지 유지");
							return false;
						}
					}else{
						System.out.println("친구가보낸 친구신청이없음");
						return false;
					}
				}else{
					System.out.println("친구가 회원이 아님");
					return false;
				}
			}else{
				System.out.println("관리자가 아님 탈락");
				return false;
			}
		}else{
			System.out.println("관리자가 아님 탈락");
			return false;
		}
	}

	@Override
	public FriendProposal searchFriendProposal(String senderId,	String receiverId) {
		// TODO Auto-generated method stub

		Factory factory = (Factory)DAOFactory.getInstance();

		//친구 신청 알람유형 코드 가져옴
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindCodeDto = (ArrayList<AlarmKindDTO> )alarmKindSearchDao.searchAlarmKindName("친구신청");

		if(alarmKindCodeDto.size() != 0)
		{
			System.out.println("알람코드 : " + alarmKindCodeDto.get(0).getAlarmKindCode().trim());
			
			String alarmKindCode = alarmKindCodeDto.get(0).getAlarmKindCode().trim();
			//보낸 사람 아이디(코드) 와 알람유형코드로 알람 리스트 가져옴
			AlarmSearchDAO alarmSearchDao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> alarmList = (ArrayList<AlarmDTO>)alarmSearchDao.searchAlarmMemberKindSenderCode(receiverId, alarmKindCode, senderId);
	
			//보낸 메시지가 있는경우
			if(alarmList.size() != 0)
			{
				String alarmCode = alarmList.get(0).getAlarmCode();
				//여기서 알람유형에 알람코드가 들어간다.
				FriendProposal friendProposal = new FriendProposal(senderId,"보낸사람이름",receiverId,"받는사람 이름",alarmCode);
				return friendProposal;				
			}else{
				return null;
			}
		}else{
			return null;
		}	
	}

	@Override
	public ArrayList<FriendProposal> searchFriendProposalSenderId(String senderId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//친구 신청 알람유형 코드 가져옴
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindCodeDto = (ArrayList<AlarmKindDTO> )alarmKindSearchDao.searchAlarmKindName("친구신청");
		if(alarmKindCodeDto.size() != 0)
		{
			String alarmKindCode = alarmKindCodeDto.get(0).getAlarmKindCode().trim();
			System.out.println(alarmKindCode);
			//보낸 사람 아이디(코드) 와 알람유형코드로 알람 리스트 가져옴
			AlarmSearchDAO alarmSearchDao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> alarmList = (ArrayList<AlarmDTO>)alarmSearchDao.searchAlarmSenderCodeAlarmKindCode(senderId, alarmKindCode);

			if(alarmList.size() != 0)
			{
				System.out.println("보낸 친구신청 메시지가 있음");
				//친구 신청 리스트 생성
				ArrayList<FriendProposal> friendProposalList = new ArrayList<FriendProposal>();

				//여기에 송신자 아이디와 이름을 집어넣어야 함..
				//친구 정보 가져오는 로직
				MemberSearchable memberSearchable = new MemberManager();



				for(AlarmDTO temp : alarmList)
				{
					FriendProposal friendProposal = new FriendProposal();

					Member friend = memberSearchable.searchMemberCode(temp.getMemberCode());

					friendProposal.setSenderId(senderId);
					friendProposal.setReceiverName(friend.getName().trim());
					friendProposal.setReceiverId(friend.getId().trim());
					friendProposal.setProposalKind(temp.getAlarmKindCode().trim());

					friendProposalList.add(friendProposal);
				}
				return friendProposalList;
			}else{
				System.out.println("내가 신청한 내역이 없음");
				return new ArrayList<FriendProposal>();
			}
		}else{
			System.out.println("친구신청 알람 코드가 없음");
			return new ArrayList<FriendProposal>();
		}	
	}

	@Override
	public ArrayList<FriendProposal> searchFriendProposalSenderName(String receiverId, String senderName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		//보낸사람 이름으로 검색하는 dao가 없음
		//1.찾는 사람이 존재하는지 확인
		MemberSearchable memberSearchable = new MemberManager();
		ArrayList<Member> senderList = (ArrayList<Member>)memberSearchable.searchMemberName(senderName);	//이름으로 검사
		Member sender = memberSearchable.searchMemberId(senderName);										//아이디로 검사
		char check = 0;//0인 경우  : 디폴트 , 1인경우 : 전체리스트에 중복되는 아이디는 없는 경우, 2인경우 : 중복되는 아이디가 있는 경우
		//2.이름으로 검색 리스트에 아이디어 검색한 결과를 넣음
		for(Member temp : senderList)
		{						
			if(sender.getId() != null)
			{
				check = 1;	//아이디가 있음
				if(temp.getId().trim().equals(sender.getId().trim())){//추가하면서 아이디로 검색한 결과와 같은 아이디가 있는지 확인
					check = 2;//같은 아이디가 있는경우
					System.out.println("줄복된다.");
				}
			}
		}
		if(check==1){//같은 아이디가 없다면
			senderList.add(sender);
		}
		//--------------------------------------------------------------------------------------------
		//보낸사람 리스트가 완성된 후 보낸사람들의 code정보를 가져옴
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		ArrayList<MemberDTO> senderCodeList = new ArrayList<MemberDTO>();							//보낸사람 코드 리스트
		for(Member temp : senderList)
		{
			MemberDTO searchMember = memberSearchDAO.searchMemberId(temp.getId().trim());
			 if(searchMember.getMemberCode() != null){
				 senderCodeList.add(searchMember);
			 }
		}
		//--------------------------------------------------------------------------------------------
		//알람 테이블에서 송신자 코드와 수신자 코드로 확인
		AlarmDAOImpl alarmDao = (AlarmDAOImpl)factory.create("Alarm");
		ArrayList<FriendProposal> friendProposals = new ArrayList<FriendProposal>();
		
		for(MemberDTO temp : senderCodeList)
		{
			ArrayList<AlarmDTO> search = (ArrayList<AlarmDTO>)alarmDao.searchAlarmMemberKindSenderCode(receiverId, "ak1", temp.getMemberCode().trim());
			if(search.size() != 0)
			{
				friendProposals.add(new FriendProposal(temp.getMemberId().trim(),temp.getName().trim()));
			}
		}
		return friendProposals;
	}

	@Override
	public ArrayList<FriendProposal> searchFriendProposalReceiverName(String senderId, String receiverName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
	
		//1.검색하려는 사람이 존재하는 확인
		MemberSearchable memberSearchable = new MemberManager();
		ArrayList<Member> receiverList = (ArrayList<Member>)memberSearchable.searchMemberName(receiverName);	//이름으로 검사
		Member receiver = memberSearchable.searchMemberId(receiverName);										//아이디로 검사
		
		char check = 0;//0인 경우  : 디폴트 , 1인경우 : 전체리스트에 중복되는 아이디는 없는 경우, 2인경우 : 중복되는 아이디가 있는 경우
		//2.이름으로 검색 리스트에 아이디어 검색한 결과를 넣음
		for(Member temp : receiverList)
		{						
			if(receiver.getId() != null)
			{
				check = 1;	//아이디가 있음
				if(temp.getId().trim().equals(receiver.getId().trim())){//추가하면서 아이디로 검색한 결과와 같은 아이디가 있는지 확인
					check = 2;//같은 아이디가 있는경우
					System.out.println("줄복된다.");
				}
			}
		}
		if(check==1){//같은 아이디가 없다면
			receiverList.add(receiver);
		}
		//--------------------------------------------------------------------------------------------
		//보낸사람 리스트가 완성된 후 보낸사람들의 code정보를 가져옴
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		ArrayList<MemberDTO> receiverCodeList = new ArrayList<MemberDTO>();							//보낸사람 코드 리스트
		for(Member temp : receiverList)
		{
			MemberDTO searchMember = memberSearchDAO.searchMemberId(temp.getId().trim());
			 if(searchMember.getMemberCode() != null){
				 receiverCodeList.add(searchMember);
			 }
		}
		//--------------------------------------------------------------------------------------------
		//알람 테이블에서 송신자 코드와 수신자 코드로 확인
		AlarmDAOImpl alarmDao = (AlarmDAOImpl)factory.create("Alarm");
		ArrayList<FriendProposal> friendProposals = new ArrayList<FriendProposal>();
		
		for(MemberDTO temp : receiverCodeList)
		{
			ArrayList<AlarmDTO> search = (ArrayList<AlarmDTO>)alarmDao.searchAlarmMemberKindSenderCode(temp.getMemberCode().trim(), "ak1",senderId);
			if(search.size() != 0)
			{
				friendProposals.add(new FriendProposal(temp.getMemberId().trim(),temp.getName().trim()));
			}
		}
		return friendProposals;
	}

	@Override
	public ArrayList<FriendProposal> searchFriendProposalReceiverId(String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");				//알람 내역을 확인 하기 위한 dao

		List<AlarmDTO> dto = dao.searchAlarmMemberKindCode(receiverId,"ak1");		//친구 신청 : ak1
		ArrayList<FriendProposal> friendProposalList = new ArrayList<FriendProposal>();

		if(dto.size() != 0){
			System.out.println("나에게온 메시지가 있음");
			//나에게 보낸 사람 정보 가져옴.(한명한명)
			for(AlarmDTO alarmDTO : dto)
			{
				//송신자의 정보를 가져오기 위해 수행
				MemberManager memberManager = new MemberManager();
				Member member = memberManager.searchMemberCode(alarmDTO.getSenderCode());
				friendProposalList.add(new FriendProposal(member.getId(),member.getName()));
			}
			return friendProposalList;
		}
		else{
			System.out.println("나에게 온 메시지가 없음");
			return null;
		}
	}

	@Override
	public boolean requestFriendProposal(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		//senderId가 사용자 receiverId 가 친구
		//1.친구가 존재하는지 확인
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(receiverId);
		
		//2.친구가 존재 한다면.
		if(member.getId() != null)
		{			
			System.out.println("친구는 회원임");
			String receiverCode = memberSearchable.searchMemberAdmin(receiverId).trim();
			//3.내가 보낸 친구제안이 있는지 확인
			if(searchFriendProposal(senderId, receiverCode)==null){
				System.out.println("내가 보냈던 친구신청이 없음");
				//4. 친구 정보를 찾기
				FriendSearchable friendSearchable = new FriendManager();
				Friend friend= friendSearchable.searchFriendId(senderId, receiverCode);
				//5. 친구신청메시지 생성
				if(friend.getFriendId() == null)
				{
					System.out.println("친구가 아니다.");
					AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
					//senderId = "memberCode" receiverId = "receiverId
					if(alarmAble.alarmFriendRequest("친구신청", receiverCode, senderId)){
						System.out.println("친구신청 메시지 생성성공");
						return true;
					}else{
						System.out.println("친구신청메시지 생성실패");
						return false;
					}	
				}else{
					System.out.println("이미 친구입니다.탈락");
					return false;
				}
			}else{
				System.out.println("이미 친구 제안을 보냈음. 탈락");
				return false;
			}
		}
		System.out.println("친구는 회원이 아님");
		return false;
	}

	@Override
	public boolean requestFriendProposal(String adminId, String senderId,String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1.관리자 아이디 여부 확인
		//세션으로 관리자 코드가 옴
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//관리자 멤버여부 확인

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("관리자아이디 회원검사 통과 ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//관리자 멤버유형코드 검색

			if(memberKindDto.getMemberKindName().trim().equals("관리자"))										//관리자 인 경우
			{
				//1.친구가 존재하는지 확인
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(receiverId);
				//2.친구가 존재 한다면.
				if(member.getId() != null)
				{
					System.out.println("친구는 회원임");
					//3.내가 보낸 친구제안이 있는지 확인
					if(searchFriendProposal(senderId, receiverId)==null){
						System.out.println("내가 보냈던 친구신청이 없음");
						//4. 친구 정보를 찾기
						FriendSearchable friendSearchable = new FriendManager();
						Friend friend= friendSearchable.searchFriendId(senderId, receiverId);
						//5. 친구신청메시지 생성
						if(friend.getFriendId() == null)
						{
							System.out.println("친구가 아니다.");
							AlarmMessageAlarmable alarmMessageAlarmable = new AlarmMessageManager();
							if(alarmMessageAlarmable.alarmFriendRequest("친구신청", receiverId, senderId)){
								System.out.println("친구신청 메시지 생성성공");
								return true;
							}else{
								System.out.println("친구신청메시지 생성실패");
								return false;
							}	
						}else{
							System.out.println("이미 친구입니다.탈락");
							return false;
						}
					}else{
						System.out.println("이미 친구 제안을 보냈음. 탈락");
						return false;
					}
				}else{
					System.out.println("친구는 회원이 아님");
					return false;
				}
			}else{
				System.out.println("관리자가 아님 탈락");
				return false;
			}
		}else{
			System.out.println("관리자가 아님 탈락");
			return false;
		}
	}
}
