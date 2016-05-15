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

		//1. ģ���� �����ϴ� ������� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);///ģ�� ���̵�� 

		if(memberCheck.getId() != null)//���� ģ���� �ش��ϴ� ����� �ִٸ�
		{
			System.out.println("ģ���� ȸ���� ����");
			String friendCode = memberSearchable.searchMemberAdmin(friendId).trim();
			
			System.out.println("ģ�� �ڵ� : " +friendCode);
			//2. ģ���� ��ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
			//�ڵ尪�� parameter�� ������
			Friend friendCheck = searchFriendId(id,friendCode);	
			//3. ��ģ�����	
			if(friendCheck != null)
			{
				System.out.println("ģ���� ��ģ����");
				FriendDAOImpl friendDao = (FriendDAOImpl)factory.create("Friend");
				
				
				//4. ���� ���� ���� Ȯ��
				if(friendDao.deleteMemberCode(id, friendCode) != 0)//������ ID�� �ڵ�� ����Ͽ� ����
				{ 
					System.out.println("��������");
					return true;//������ ��� true����
				}else{
					System.out.println("��������");
					return false;
				}
			}else{
				System.out.println("ģ���� ��ģ���� �ƴ� Ż��");
				return false;
			}
		}else{
			System.out.println("ģ���� ȸ���� �ƴ� Ż��");
			return false;
		}
	}

	@Override
	public boolean deleteFriend(String adminId, String memberId, String friendId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//1.������ ���̵� ���� Ȯ��
		//�������� ������ �ڵ尡 ��
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//������ ������� Ȯ��

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("�����ھ��̵� ȸ���˻� ��� ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//������ ��������ڵ� �˻�

			if(memberKindDto.getMemberKindName().trim().equals("������"))										//������ �� ���
			{
				System.out.println("�����ڰ˻� ���");
				//1. ģ���� �����ϴ� ������� Ȯ��
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);

				if(memberCheck.getId() != null)//���� ģ���� �ش��ϴ� ����� �ִٸ�
				{
					System.out.println("ģ���� ȸ���� ����");
					//2. ģ���� ��ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
					//�ڵ尪�� parameter�� ������
					Friend friendCheck = searchFriendId(memberId,friendId);	
					//3. ��ģ�����	
					if(friendCheck != null)
					{
						System.out.println("ģ���� ��ģ����");
						FriendDeleteDAO dao = (FriendDeleteDAO)factory.create("Friend");
						//4. ���� ���� ���� Ȯ��
						if(dao.deleteFriendMemberCode(friendCheck.getFriendId()) != 0)//������ ID�� �ڵ�� ����Ͽ� ����
						{ 
							System.out.println("��������");
							return true;//������ ��� true����
						}else{
							System.out.println("��������");
							return false;
						}
					}else{
						System.out.println("ģ���� ��ģ���� �ƴ� Ż��");
						return false;
					}
				}else{
					System.out.println("ģ���� ȸ���� �ƴ� Ż��");
					return false;
				}	
			}else{
				System.out.println("�����ڰ� �ƴ� Ż��");
				return false;
			}
		}else{
			System.out.println("�����ڰ� �ƴ� Ż��");
			return false;
		}
	}

	@Override
	public boolean modifyFriendGroup(String memberId, String friendId, Group groupKind) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		//1. ģ���� ȸ�� ���� Ȯ�� /�ڵ尪
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);

		//3. ���� ģ���� �ش��ϴ� ����� �ִٸ�
		if( memberCheck.getId() != null)
		{
			System.out.println("ģ���� ȸ����");
			
			String friendCode = memberSearchable.searchMemberAdmin(friendId).trim();
			
			//4. ģ���� ������� ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
			Friend friendCheck = searchFriendId(memberId,friendCode);	//���⿡ ģ�� ���̵� �ƴ� �ڵ带 ������
			//��ģ����� 
			if(friendCheck.getFriendId() != null)
			{
				
				System.out.println("ģ���� �� ģ����");
				//5. �׷����� ��������<<�̺κ��� �������� ���� �߰��� �κ�>>
				GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
				GroupDTO dto = gDao.searchMemberCodeGroupName(memberId, groupKind.value());
				
				FriendUpdateDAO dao = (FriendUpdateDAO)factory.create("Friend");
				//6. ���� ���� ���� Ȯ�� �� ������ �׷��ڵ�� �׷� ����
				if(dao.updateFriendGroup(memberId, friendCode,dto.getGroupCode().trim()) != 0)
				{ 
					System.out.println("�׷캯�� ����");
					return true;//�׷캯�� ����
				}else{
					System.out.println("�׷캯�����");
					return false;
				}
			}else{
				System.out.println("ģ���� ��ģ���� �ƴ�");
				return false;
			}
		}else{
			System.out.println("ģ���� ȸ���� �ƴ�");
			return false;
		}
	}

	@Override
	public boolean modifyFriendGroup(String adminId, String memberId,String friendId, Group groupKind) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//1.������ ���̵� ���� Ȯ��
		//�������� ������ �ڵ尡 ��
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//������ ������� Ȯ��

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("�����ھ��̵� ȸ���˻� ��� ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//������ ��������ڵ� �˻�

			if(memberKindDto.getMemberKindName().trim().equals("������"))										//������ �� ���
			{
				System.out.println("�����ڰ˻� ���");
				//1. ģ���� ȸ�� ���� Ȯ�� /�ڵ尪
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);

				//3. ���� ģ���� �ش��ϴ� ����� �ִٸ�
				if( memberCheck != null)
				{
					System.out.println("ģ���� ȸ����");
					//4. ģ���� ������� ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
					Friend friendCheck = searchFriendId(memberId,friendId);	//���⿡ ģ�� ���̵� �ƴ� �ڵ带 ������
					//��ģ����� 
					if(friendCheck != null)
					{
						System.out.println("ģ���� �� ģ����");
						//5. �׷����� ��������<<�̺κ��� �������� ���� �߰��� �κ�>>
						GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
						GroupDTO dto = gDao.searchMemberCodeGroupName(memberId, groupKind.value());

						FriendUpdateDAO dao = (FriendUpdateDAO)factory.create("Friend");
						//6. ���� ���� ���� Ȯ�� �� ������ �׷��ڵ�� �׷� ����
						if(dao.updateFriendGroup(memberId, friendId,dto.getGroupCode().trim()) != 0)
						{ 
							System.out.println("�׷캯�� ����");
							return true;//�׷캯�� ����
						}else{
							System.out.println("�׷캯�����");
							return false;
						}
					}else{
						System.out.println("ģ���� ��ģ���� �ƴ� Ż��");
						return false;
					}
				}else{
					System.out.println("ģ���� ȸ���� �ƴ� Ż��");
					return false;
				}	
			}else{
				System.out.println("�����ڰ� �ƴ� Ż��");
				return false;
			}
		}else{
			System.out.println("�����ڰ� �ƴ� Ż��");
			return false;
		}
	}

	@Override
	public boolean acceptFriendProposal(String id, String friendId) {
		// TODO Auto-generated method stub

		Factory factory = (Factory)DAOFactory.getInstance();
		//1. ģ���� ȸ�� ���� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();			
		Member memberCheck = memberSearchable.searchMemberId(friendId);
		if(memberCheck.getId() != null)
		{
			System.out.println("ģ���� ȸ����");
			MemberSearchDAO friendSearchDao = (MemberSearchDAO)factory.create("Member");
			MemberDTO friendInfo = friendSearchDao.searchMemberId(friendId);
			System.out.println("ģ�� �ڵ� : " +friendInfo.getMemberCode().trim());
			String friendCode = friendInfo.getMemberCode().trim();



			//5. ������ ���� �˶� ������Ʈ	
			AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
			if(alarmAble.alarmFriendAccept(friendCode, id, "ģ������"))
			{
				System.out.println("�˶� ���� ����");
				//6. �׷����� ��������<<�̺κ��� �������� ���� �߰��� �κ�>>
				GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
				GroupDTO gdtoMember = gDao.searchMemberCodeGroupName(id, "ģ��");	
				GroupDTO gdtoFriend = gDao.searchMemberCodeGroupName(friendCode, "ģ��");
				FriendInsertDAO fdao = (FriendInsertDAO)factory.create("Friend");
				//ģ�� ���� ������Ʈ �κ�--------------------------------------------------------------------
				//4. ģ���� ������� ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
				Friend friendCheck = searchFriendId(id,friendCode);	//���⿡ ģ�� ���̵� �ƴ� �ڵ带 ������
				//��ģ���� �ƴ϶��
				if(friendCheck.getFriendId() == null){
					System.out.println("ģ���ƴ�");
					//6. ģ�� �߰�
					if(fdao.insertFriend(gdtoMember.getGroupCode().trim(), id, friendCode)){
						fdao.insertFriend(gdtoFriend.getGroupCode().trim(), friendCode, id);
						System.out.println("ģ�� �߰�����");
						return true;
					}else{
						System.out.println("ģ���߰� ����");
						return false;
					}		
				}else{
					System.out.println("��û�� ����� ģ�� �߰�");
					fdao.insertFriend(gdtoFriend.getGroupCode().trim(), friendCode, id);
					return true;
				}//-------------------------------------------------------------------------------
			}else{
				System.out.println("�����Կ� �˶��� ����/ģ���߰� ����");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean acceptFriendProposal(String adminId, String memberId,String friendId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//1.������ ���̵� ���� Ȯ��
		//�������� ������ �ڵ尡 ��
		MemberSearchDAO adminMemberSearch = (MemberSearchDAO)factory.create("Member");
		MemberDTO adminDto = adminMemberSearch.searchMemberCode(adminId);						//������ ������� Ȯ��

		if(adminDto.getMemberCode() != null)
		{
			System.out.println("�����ھ��̵� ȸ���˻� ��� ");

			MemberKindSearchDAO memberKindDao = (MemberKindSearchDAO)factory.create("MemberKind");	
			MemberKindDTO memberKindDto =  memberKindDao.searchMemberKindCode(adminDto.getMemberKindCode().trim());//������ ��������ڵ� �˻�

			if(memberKindDto.getMemberKindName().trim().equals("������"))										//������ �� ���
			{
				//1. ģ���� ȸ�� ���� Ȯ��
				MemberSearchable memberSearchable = new MemberManager();			
				Member memberCheck = memberSearchable.searchMemberCode(friendId);
				if(memberCheck.getId() != null)
				{
					System.out.println("ģ���� ȸ����");
					//4. ģ���� ������� ģ������ Ȯ��(FriendSearchable��  searchFriendId �̿�)
					Friend friendCheck = searchFriendId(memberId,friendId);	//���⿡ ģ�� ���̵� �ƴ� �ڵ带 ������
					//��ģ���� �ƴ϶��
					if(friendCheck == null){
						System.out.println("ģ���ƴ�");
						//5. ������ ���� �˶� ������Ʈ	
						AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
						if(alarmAble.alarmFriendAccept(friendId, memberId, "ģ������"))
						{
							System.out.println("�˶� ���� ����");
							//6. �׷����� ��������<<�̺κ��� �������� ���� �߰��� �κ�>>
							GroupSearchDAO gDao = (GroupSearchDAO)factory.create("Group");
							GroupDTO gdto = gDao.searchMemberCodeGroupName(memberId, "ģ��");	
							FriendInsertDAO fdao = (FriendInsertDAO)factory.create("Friend");
							//6. ģ�� �߰�
							if(fdao.insertFriend(gdto.getGroupCode().trim(), memberId, friendId)){
								fdao.insertFriend(gdto.getGroupCode().trim(), friendId, memberId);
								System.out.println("ģ�� �߰�����");
								return true;
							}else{
								System.out.println("ģ���߰� ����");
								return false;
							}		
						}else{
							System.out.println("�����Կ� �˶��� ����/ģ���߰� ����");
							return false;
						}
					}else{
						System.out.println("ģ����");
						return false;
					}
				}
				System.out.println("ģ���� ȸ���� �ƴ� Ż��");
				return false;
			}else{
				System.out.println("�����ڰ� �ƴ� Ż��");
				return false;
			}
		}else{
			System.out.println("�����ڰ� �ƴ� Ż��");
			return false;
		}
	}

	@Override
	public Friend searchFriendId(String id, String friendId) {//�Ѵ� �ڵ� ���̴�..
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//1. ���� ģ�� ���̵�� ģ��DB���� �˻� - ��� parameter�� �ڵ�� �޴´�.
		FriendSearchDAO dao= (FriendSearchDAO)factory.create("Friend");

		System.out.println("����� ������Ŵ���"+id+" "+ friendId);	

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
		//ģ�� �̸����� �˻��ϴ� dao�� ����

		return null;
	}

	@Override
	public ArrayList<Friend> searchFriendGroupKind(String id, String groupKind) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();

		//����� ���̵�(�ڵ�)�� �׷� �̸����� �׷� �ڵ� �˻�
		GroupSearchDAO gdao = (GroupSearchDAO)factory.create("Group");
		GroupDTO gdto = gdao.searchMemberCodeGroupName(id, groupKind);
		System.out.println(gdto.getGroupName());
		//�׷��� �����ϴ� ���
		if(gdto != null)
		{
			//�׷��ڵ带 ������
			String groupCode = gdto.getGroupCode();
			System.out.println("�׷��ڵ� :" +  groupCode);
			//ģ���׷쿡�� ����� ���̵� �ش��ϴ� �׷� ģ�� ������ ��� ������
			FriendSearchDAO fdao = (FriendSearchDAO)factory.create("Friend");
			ArrayList<FriendDTO> fdto = (ArrayList<FriendDTO>)fdao.searchGroupMemberCode(groupCode, id);
			//�׷��ο��� ã�� ���
			if(fdto.size() != 0)
			{
				ArrayList<Friend> friendList = new ArrayList<Friend>();
				for(FriendDTO ftemp : fdto)
				{
					//ģ�� �ڵ� ���� ���� Friend��ü�� �����Ͽ� ����Ʈ�� �߰�
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

		//����� ���̵�(�ڵ�)�� ģ�� �˻�
		MemberFriendVDAO memberFriendVDAO = (MemberFriendVDAO)factory.create("MemberFriendView");
		List<MemberFriendVDTO> friendDTOList = memberFriendVDAO.searchMemberFriend(id);
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		for(MemberFriendVDTO temp : friendDTOList) {
			friendList.add(new Friend(temp.getFriendMemberId(), temp.getFriendMemberName()));
		}
		return friendList;
	}
}
