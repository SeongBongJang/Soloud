package com.soloud.app.man;

import java.util.ArrayList;
import java.util.List;

import com.soloud.app.manInt.AlarmMessageAlarmable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.Friend;
import com.soloud.app.model.Group;
import com.soloud.app.model.Member;
import com.soloud.per.dao.FriendDeleteDAO;
import com.soloud.per.dao.FriendInsertDAO;
import com.soloud.per.dao.FriendSearchDAO;
import com.soloud.per.dao.FriendUpdateDAO;
import com.soloud.per.dao.GroupSearchDAO;
import com.soloud.per.dao.MemberFriendVDAO;
import com.soloud.per.dao.MemberKindSearchDAO;
import com.soloud.per.dao.MemberSearchDAO;
import com.soloud.per.daoimpl.FriendDAOImpl;
import com.soloud.per.dto.FriendDTO;
import com.soloud.per.dto.GroupDTO;
import com.soloud.per.dto.MemberDTO;
import com.soloud.per.dto.MemberFriendVDTO;
import com.soloud.per.dto.MemberKindDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;

public class FriendManager extends AbstractFriendManager{

	@Override
	public boolean deleteFriend(String id, String friendId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//1. 친구가 존재하는 멤버인지 확인
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);///친구 아이디로 

		if(memberCheck.getId() != null)//만약 친구에 해당하는 멤버가 있다면
		{
			System.out.println("친구는 회원이 맞음");
			String friendCode = memberSearchable.searchMemberAdmin(friendId).trim();
			
			System.out.println("친구 코드 : " +friendCode);
			//2. 친구가 내친구인지 확인(FriendSearchable의  searchFriendId 이용)
			//코드값을 parameter로 보낸다
			Friend friendCheck = searchFriendId(id,friendCode);	
			//3. 내친구라면	
			if(friendCheck != null)
			{
				System.out.println("친구는 내친구임");
				FriendDAOImpl friendDao = (FriendDAOImpl)factory.create("Friend");
				
				
				//4. 삭제 성공 여부 확인
				if(friendDao.deleteMemberCode(id, friendCode) != 0)//가져온 ID를 코드로 사용하여 삭제
				{ 
					System.out.println("삭제성공");
					return true;//삭제된 경우 true리턴
				}else{
					System.out.println("삭제실패");
					return false;
				}
			}else{
				System.out.println("친구는 내친구가 아님 탈락");
				return false;
			}
		}else{
			System.out.println("친구는 회원이 아님 탈락");
			return false;
		}
	}

	@Override
	public boolean deleteFriend(String adminId, String memberId, String friendId) {
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
				System.out.println("관리자검사 통과");
				//1. 친구가 존재하는 멤버인지 확인
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);

				if(memberCheck.getId() != null)//만약 친구에 해당하는 멤버가 있다면
				{
					System.out.println("친구는 회원이 맞음");
					//2. 친구가 내친구인지 확인(FriendSearchable의  searchFriendId 이용)
					//코드값을 parameter로 보낸다
					Friend friendCheck = searchFriendId(memberId,friendId);	
					//3. 내친구라면	
					if(friendCheck != null)
					{
						System.out.println("친구는 내친구임");
						FriendDeleteDAO dao = (FriendDeleteDAO)factory.create("Friend");
						//4. 삭제 성공 여부 확인
						if(dao.deleteFriendMemberCode(friendCheck.getFriendId()) != 0)//가져온 ID를 코드로 사용하여 삭제
						{ 
							System.out.println("삭제성공");
							return true;//삭제된 경우 true리턴
						}else{
							System.out.println("삭제실패");
							return false;
						}
					}else{
						System.out.println("친구는 내친구가 아님 탈락");
						return false;
					}
				}else{
					System.out.println("친구는 회원이 아님 탈락");
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
	public boolean modifyFriendGroup(String memberId, String friendId, Group groupKind) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		//1. 친구의 회원 여부 확인 /코드값
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);

		//3. 만약 친구에 해당하는 멤버가 있다면
		if( memberCheck.getId() != null)
		{
			System.out.println("친구는 회원임");
			
			String friendCode = memberSearchable.searchMemberAdmin(friendId).trim();
			
			//4. 친구가 사용자의 친구인지 확인(FriendSearchable의  searchFriendId 이용)
			Friend friendCheck = searchFriendId(memberId,friendCode);	//여기에 친구 아이디가 아닌 코드를 가져옴
			//내친구라면 
			if(friendCheck.getFriendId() != null)
			{
				
				System.out.println("친구는 내 친구임");
				//5. 그룹정보 가져오기<<이부분은 시퀀스에 없는 추가된 부분>>
				GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
				GroupDTO dto = gDao.searchMemberCodeGroupName(memberId, groupKind.value());
				
				FriendUpdateDAO dao = (FriendUpdateDAO)factory.create("Friend");
				//6. 삭제 성공 여부 확인 후 가져온 그룹코드로 그룹 변경
				if(dao.updateFriendGroup(memberId, friendCode,dto.getGroupCode().trim()) != 0)
				{ 
					System.out.println("그룹변경 성공");
					return true;//그룹변경 성공
				}else{
					System.out.println("그룹변경실패");
					return false;
				}
			}else{
				System.out.println("친구는 내친구가 아님");
				return false;
			}
		}else{
			System.out.println("친구는 회원이 아님");
			return false;
		}
	}

	@Override
	public boolean modifyFriendGroup(String adminId, String memberId,String friendId, Group groupKind) {
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
				System.out.println("관리자검사 통과");
				//1. 친구의 회원 여부 확인 /코드값
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);

				//3. 만약 친구에 해당하는 멤버가 있다면
				if( memberCheck != null)
				{
					System.out.println("친구는 회원임");
					//4. 친구가 사용자의 친구인지 확인(FriendSearchable의  searchFriendId 이용)
					Friend friendCheck = searchFriendId(memberId,friendId);	//여기에 친구 아이디가 아닌 코드를 가져옴
					//내친구라면 
					if(friendCheck != null)
					{
						System.out.println("친구는 내 친구임");
						//5. 그룹정보 가져오기<<이부분은 시퀀스에 없는 추가된 부분>>
						GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
						GroupDTO dto = gDao.searchMemberCodeGroupName(memberId, groupKind.value());

						FriendUpdateDAO dao = (FriendUpdateDAO)factory.create("Friend");
						//6. 삭제 성공 여부 확인 후 가져온 그룹코드로 그룹 변경
						if(dao.updateFriendGroup(memberId, friendId,dto.getGroupCode().trim()) != 0)
						{ 
							System.out.println("그룹변경 성공");
							return true;//그룹변경 성공
						}else{
							System.out.println("그룹변경실패");
							return false;
						}
					}else{
						System.out.println("친구는 내친구가 아님 탈락");
						return false;
					}
				}else{
					System.out.println("친구는 회원이 아님 탈락");
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
	public boolean acceptFriendProposal(String id, String friendId) {
		// TODO Auto-generated method stub

		Factory factory = (Factory)DAOFactory.getInstance();
		//1. 친구의 회원 여부 확인
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);
		if(memberCheck.getId() != null)
		{
			System.out.println("친구는 회원임");
			MemberSearchDAO friendSearchDao = (MemberSearchDAO)factory.create("Member");
			MemberDTO friendInfo = friendSearchDao.searchMemberId(friendId);
			System.out.println("친구 코드 : " +friendInfo.getMemberCode().trim());
			String friendCode = friendInfo.getMemberCode().trim();



			//5. 나에게 보낸 알람 업데이트	
			AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
			if(alarmAble.alarmFriendAccept(friendCode, id, "친구수락"))
			{
				System.out.println("알람 업뎃 성공");
				//6. 그룹정보 가져오기<<이부분은 시퀀스에 없는 추가된 부분>>
				GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
				GroupDTO gdtoMember = gDao.searchMemberCodeGroupName(id, "친구");	
				GroupDTO gdtoFriend = gDao.searchMemberCodeGroupName(friendCode, "친구");
				FriendInsertDAO fdao = (FriendInsertDAO)factory.create("Friend");
				//친구 정보 업데이트 부분--------------------------------------------------------------------
				//4. 친구가 사용자의 친구인지 확인(FriendSearchable의  searchFriendId 이용)
				Friend friendCheck = searchFriendId(id,friendCode);	//여기에 친구 아이디가 아닌 코드를 가져옴
				//내친구라가 아니라면
				if(friendCheck.getFriendId() == null){
					System.out.println("친구아님");
					//6. 친구 추가
					if(fdao.insertFriend(gdtoMember.getGroupCode().trim(), id, friendCode)){
						fdao.insertFriend(gdtoFriend.getGroupCode().trim(), friendCode, id);
						System.out.println("친구 추가성공");
						return true;
					}else{
						System.out.println("친구추가 실패");
						return false;
					}		
				}else{
					System.out.println("신청한 사람만 친구 추가");
					fdao.insertFriend(gdtoFriend.getGroupCode().trim(), friendCode, id);
					return true;
				}//-------------------------------------------------------------------------------
			}else{
				System.out.println("나에게온 알람이 없음/친구추가 실패");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean acceptFriendProposal(String adminId, String memberId,String friendId) {
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
				//1. 친구의 회원 여부 확인
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);
				if(memberCheck.getId() != null)
				{
					System.out.println("친구는 회원임");
					//4. 친구가 사용자의 친구인지 확인(FriendSearchable의  searchFriendId 이용)
					Friend friendCheck = searchFriendId(memberId,friendId);	//여기에 친구 아이디가 아닌 코드를 가져옴
					//내친구라가 아니라면
					if(friendCheck == null){
						System.out.println("친구아님");
						//5. 나에게 보낸 알람 업데이트	
						AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
						if(alarmAble.alarmFriendAccept(friendId, memberId, "친구수락"))
						{
							System.out.println("알람 업뎃 성공");
							//6. 그룹정보 가져오기<<이부분은 시퀀스에 없는 추가된 부분>>
							GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
							GroupDTO gdto = gDao.searchMemberCodeGroupName(memberId, "친구");	
							FriendInsertDAO fdao = (FriendInsertDAO)factory.create("Friend");
							//6. 친구 추가
							if(fdao.insertFriend(gdto.getGroupCode().trim(), memberId, friendId)){
								fdao.insertFriend(gdto.getGroupCode().trim(), friendId, memberId);
								System.out.println("친구 추가성공");
								return true;
							}else{
								System.out.println("친구추가 실패");
								return false;
							}		
						}else{
							System.out.println("나에게온 알람이 없음/친구추가 실패");
							return false;
						}
					}else{
						System.out.println("친구임");
						return false;
					}
				}
				System.out.println("친구는 회원이 아님 탈락");
				return false;
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
	public Friend searchFriendId(String id, String friendId) {//둘다 코드 값이다..
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. 나와 친구 아이디로 친구DB에서 검색 - 모든 parameter는 코드로 받는다.
		FriendSearchDAO dao= (FriendSearchDAO)factory.create("Friend");

		System.out.println("여기는 프렌드매니저"+id+" "+ friendId);	

		MemberSearchable  memberSearchable = new MemberManager();
		Member friendInfo = memberSearchable.searchMemberCode(friendId);

		FriendDTO friend = dao.searchMemberCodeFriendMemberCode(id, friendId); 
		//System.out.println(memberDTO);
		if(friend.getFriendMemberCode() != null)
		{
			Friend ff = new Friend(friend.getFriendMemberCode().trim(), friendInfo.getName().trim());
			System.out.println(ff);
			return ff;
		}
		return new Friend();
	}

	@Override
	public ArrayList<Friend> searchFriendName(String id, String friendName) {
		// TODO Auto-generated method stub
		//친구 이름으로 검색하는 dao가 없음

		return null;
	}

	@Override
	public ArrayList<Friend> searchFriendGroupKind(String id, String groupKind) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//사용자 아이디(코드)와 그룹 이름으로 그룹 코드 검색
		GroupSearchDAO gdao = (GroupSearchDAO)factory.create("Group");
		GroupDTO gdto = gdao.searchMemberCodeGroupName(id, groupKind);
		System.out.println(gdto.getGroupName());
		//그룹이 존재하는 경우
		if(gdto != null)
		{
			//그룹코드를 가져옴
			String groupCode = gdto.getGroupCode();
			System.out.println("그룹코드 :" +  groupCode);
			//친구그룹에서 사용자 아이디에 해당하는 그룹 친구 정보를 모두 가져옴
			FriendSearchDAO fdao = (FriendSearchDAO)factory.create("Friend");
			ArrayList<FriendDTO> fdto = (ArrayList<FriendDTO>)fdao.searchGroupMemberCode(groupCode, id);
			//그룹인원을 찾은 경우
			if(fdto.size() != 0)
			{
				ArrayList<Friend> friendList = new ArrayList<Friend>();
				for(FriendDTO ftemp : fdto)
				{
					//친구 코드 값만 가진 Friend객체를 생성하여 리스트에 추가
					friendList.add(new Friend(ftemp.getFriendCode()));
				}
				return friendList;
			}
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<Friend> searchFriendList(String id) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//사용자 아이디(코드)로 친구 검색
		MemberFriendVDAO memberFriendVDAO = (MemberFriendVDAO)factory.create("MemberFriendView");
		List<MemberFriendVDTO> friendDTOList = memberFriendVDAO.searchMemberFriend(id);
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		for(MemberFriendVDTO temp : friendDTOList) {
			friendList.add(new Friend(temp.getFriendMemberId(), temp.getFriendMemberName()));
		}
		return friendList;
	}
}
