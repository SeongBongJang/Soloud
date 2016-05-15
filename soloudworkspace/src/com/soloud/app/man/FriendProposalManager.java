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
		//senderId : �� receiverId : ģ�����
		//1.ģ������� �����ϴ��� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(receiverId);
		if(member.getId() != null)
		{
			System.out.println("ģ���� ȸ����");
			//ģ�� ���� �˻�
			MemberSearchDAO memberSearchDao = (MemberSearchDAO)factory.create("Member");
			MemberDTO memberInfo = memberSearchDao.searchMemberId(receiverId);
			System.out.println("ģ�� �ڵ� : " +memberInfo.getMemberCode().trim());
			//2. ���� ���� �� ģ�� ��û�� �ִ��� Ȯ��
			FriendProposal friendProposal = searchFriendProposal(senderId, memberInfo.getMemberCode().trim());//�� ģ�����
			if(friendProposal != null)
			{
				System.out.println("���� ������ ��û�� ����");
				AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
				//���⼭ �˶� ���� ������ �˶� �ڵ尡 ���ִ�.
				if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
				{
					System.out.println("ģ����û��Ҽ���");
					return true;
				}else{
					System.out.println("ģ����û��ҽ���");
					return false;
				}
			}else{
				System.out.println("��û�� ������ ����");
				return false;
			}
		}else{
			System.out.println("ģ���� ȸ���� �ƴ�");
			return false;
		}
	}

	@Override
	public boolean cancelFriendProposal(String adminId, String senderId, String receiverId) {
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
				//senderId : �� receiverId : ģ�����
				//1.ģ������� �����ϴ��� Ȯ��
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(receiverId);
				if(member.getId() != null)
				{
					System.out.println("ģ���� ȸ����");
					//2. ���� ���� �� ģ�� ��û�� �ִ��� Ȯ��
					FriendProposal friendProposal = searchFriendProposal(senderId, receiverId);//�� ģ�����
					if(friendProposal != null)
					{
						System.out.println("���� ������ ��û�� ����");
						AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
						//���⼭ �˶� ���� ������ �˶� �ڵ尡 ���ִ�.
						if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
						{
							System.out.println("ģ����û��Ҽ���");
							return true;
						}else{
							System.out.println("ģ����û��ҽ���");
							return false;
						}
					}else{
						System.out.println("��û�� ������ ����");
						return false;
					}
				}else{
					System.out.println("ģ���� ȸ���� �ƴ�");
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
	public boolean refuseFriendProposal(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		//senderId�� ģ�� receiverId�� ���� �����
		//1.ģ���� �����ϴ��� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(senderId);
		if(member.getId() != null)
		{
			System.out.println("ģ���� ȸ����");
			String friendCode = memberSearchable.searchMemberAdmin(senderId).trim();
			System.out.println("ģ�� �ڵ� : " +friendCode);
			//2. ģ���� ������ ���� ���� Ȯ��
			FriendProposal friendProposal = searchFriendProposal(friendCode, receiverId);//ģ�� ��
			if(friendProposal != null)
			{
				System.out.println("ģ���� ���� ģ����û�� ����");
				AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
				//���⼭ �˶� ���� ������ �˶� �ڵ尡 ���ִ�.
				if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
				{
					System.out.println("��������, �޽��� ����");
					return true;
				}else{
					System.out.println("���� ���� , �޽��� ����");
					return false;
				}
			}else{
				System.out.println("ģ�������� ģ����û�̾���");
				return false;
			}
		}else{
			System.out.println("ģ���� ȸ���� �ƴ�");
			return false;
		}
	}

	@Override
	public boolean refuseFriendProposal(String adminId, String senderId,String receiverId) {
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
				//senderId�� ģ�� receiverId�� ���� �����
				//1.ģ���� �����ϴ��� Ȯ��
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(senderId);
				if(member != null)
				{
					System.out.println("ģ���� ȸ����");
					//2. ģ���� ������ ���� ���� Ȯ��
					FriendProposal friendProposal = searchFriendProposal(senderId, receiverId);//ģ�� ��
					if(friendProposal != null)
					{
						System.out.println("ģ���� ���� ģ����û�� ����");
						AlarmDeleteDAO alarmDeleteDao = (AlarmDeleteDAO)factory.create("Alarm");
						//���⼭ �˶� ���� ������ �˶� �ڵ尡 ���ִ�.
						if(alarmDeleteDao.deleteAlarmCode(friendProposal.getProposalKind()) != 0)
						{
							System.out.println("��������, �޽��� ����");
							return true;
						}else{
							System.out.println("���� ���� , �޽��� ����");
							return false;
						}
					}else{
						System.out.println("ģ�������� ģ����û�̾���");
						return false;
					}
				}else{
					System.out.println("ģ���� ȸ���� �ƴ�");
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
	public FriendProposal searchFriendProposal(String senderId,	String receiverId) {
		// TODO Auto-generated method stub

		Factory factory = (Factory)DAOFactory.getInstance();

		//ģ�� ��û �˶����� �ڵ� ������
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindCodeDto = (ArrayList<AlarmKindDTO> )alarmKindSearchDao.searchAlarmKindName("ģ����û");

		if(alarmKindCodeDto.size() != 0)
		{
			System.out.println("�˶��ڵ� : " + alarmKindCodeDto.get(0).getAlarmKindCode().trim());
			
			String alarmKindCode = alarmKindCodeDto.get(0).getAlarmKindCode().trim();
			//���� ��� ���̵�(�ڵ�) �� �˶������ڵ�� �˶� ����Ʈ ������
			AlarmSearchDAO alarmSearchDao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> alarmList = (ArrayList<AlarmDTO>)alarmSearchDao.searchAlarmMemberKindSenderCode(receiverId, alarmKindCode, senderId);
	
			//���� �޽����� �ִ°��
			if(alarmList.size() != 0)
			{
				String alarmCode = alarmList.get(0).getAlarmCode();
				//���⼭ �˶������� �˶��ڵ尡 ����.
				FriendProposal friendProposal = new FriendProposal(senderId,"��������̸�",receiverId,"�޴»�� �̸�",alarmCode);
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

		//ģ�� ��û �˶����� �ڵ� ������
		AlarmKindSearchDAO alarmKindSearchDao = (AlarmKindSearchDAO)factory.create("AlarmKind");
		ArrayList<AlarmKindDTO> alarmKindCodeDto = (ArrayList<AlarmKindDTO> )alarmKindSearchDao.searchAlarmKindName("ģ����û");
		if(alarmKindCodeDto.size() != 0)
		{
			String alarmKindCode = alarmKindCodeDto.get(0).getAlarmKindCode().trim();
			System.out.println(alarmKindCode);
			//���� ��� ���̵�(�ڵ�) �� �˶������ڵ�� �˶� ����Ʈ ������
			AlarmSearchDAO alarmSearchDao = (AlarmSearchDAO)factory.create("Alarm");
			ArrayList<AlarmDTO> alarmList = (ArrayList<AlarmDTO>)alarmSearchDao.searchAlarmSenderCodeAlarmKindCode(senderId, alarmKindCode);

			if(alarmList.size() != 0)
			{
				System.out.println("���� ģ����û �޽����� ����");
				//ģ�� ��û ����Ʈ ����
				ArrayList<FriendProposal> friendProposalList = new ArrayList<FriendProposal>();

				//���⿡ �۽��� ���̵�� �̸��� ����־�� ��..
				//ģ�� ���� �������� ����
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
				System.out.println("���� ��û�� ������ ����");
				return new ArrayList<FriendProposal>();
			}
		}else{
			System.out.println("ģ����û �˶� �ڵ尡 ����");
			return new ArrayList<FriendProposal>();
		}	
	}

	@Override
	public ArrayList<FriendProposal> searchFriendProposalSenderName(String receiverId, String senderName) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		//������� �̸����� �˻��ϴ� dao�� ����
		//1.ã�� ����� �����ϴ��� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();
		ArrayList<Member> senderList = (ArrayList<Member>)memberSearchable.searchMemberName(senderName);	//�̸����� �˻�
		Member sender = memberSearchable.searchMemberId(senderName);										//���̵�� �˻�
		char check = 0;//0�� ���  : ����Ʈ , 1�ΰ�� : ��ü����Ʈ�� �ߺ��Ǵ� ���̵�� ���� ���, 2�ΰ�� : �ߺ��Ǵ� ���̵� �ִ� ���
		//2.�̸����� �˻� ����Ʈ�� ���̵�� �˻��� ����� ����
		for(Member temp : senderList)
		{						
			if(sender.getId() != null)
			{
				check = 1;	//���̵� ����
				if(temp.getId().trim().equals(sender.getId().trim())){//�߰��ϸ鼭 ���̵�� �˻��� ����� ���� ���̵� �ִ��� Ȯ��
					check = 2;//���� ���̵� �ִ°��
					System.out.println("�ٺ��ȴ�.");
				}
			}
		}
		if(check==1){//���� ���̵� ���ٸ�
			senderList.add(sender);
		}
		//--------------------------------------------------------------------------------------------
		//������� ����Ʈ�� �ϼ��� �� ����������� code������ ������
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		ArrayList<MemberDTO> senderCodeList = new ArrayList<MemberDTO>();							//������� �ڵ� ����Ʈ
		for(Member temp : senderList)
		{
			MemberDTO searchMember = memberSearchDAO.searchMemberId(temp.getId().trim());
			 if(searchMember.getMemberCode() != null){
				 senderCodeList.add(searchMember);
			 }
		}
		//--------------------------------------------------------------------------------------------
		//�˶� ���̺��� �۽��� �ڵ�� ������ �ڵ�� Ȯ��
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
	
		//1.�˻��Ϸ��� ����� �����ϴ� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();
		ArrayList<Member> receiverList = (ArrayList<Member>)memberSearchable.searchMemberName(receiverName);	//�̸����� �˻�
		Member receiver = memberSearchable.searchMemberId(receiverName);										//���̵�� �˻�
		
		char check = 0;//0�� ���  : ����Ʈ , 1�ΰ�� : ��ü����Ʈ�� �ߺ��Ǵ� ���̵�� ���� ���, 2�ΰ�� : �ߺ��Ǵ� ���̵� �ִ� ���
		//2.�̸����� �˻� ����Ʈ�� ���̵�� �˻��� ����� ����
		for(Member temp : receiverList)
		{						
			if(receiver.getId() != null)
			{
				check = 1;	//���̵� ����
				if(temp.getId().trim().equals(receiver.getId().trim())){//�߰��ϸ鼭 ���̵�� �˻��� ����� ���� ���̵� �ִ��� Ȯ��
					check = 2;//���� ���̵� �ִ°��
					System.out.println("�ٺ��ȴ�.");
				}
			}
		}
		if(check==1){//���� ���̵� ���ٸ�
			receiverList.add(receiver);
		}
		//--------------------------------------------------------------------------------------------
		//������� ����Ʈ�� �ϼ��� �� ����������� code������ ������
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		ArrayList<MemberDTO> receiverCodeList = new ArrayList<MemberDTO>();							//������� �ڵ� ����Ʈ
		for(Member temp : receiverList)
		{
			MemberDTO searchMember = memberSearchDAO.searchMemberId(temp.getId().trim());
			 if(searchMember.getMemberCode() != null){
				 receiverCodeList.add(searchMember);
			 }
		}
		//--------------------------------------------------------------------------------------------
		//�˶� ���̺��� �۽��� �ڵ�� ������ �ڵ�� Ȯ��
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
		AlarmSearchDAO dao = (AlarmSearchDAO)factory.create("Alarm");				//�˶� ������ Ȯ�� �ϱ� ���� dao

		List<AlarmDTO> dto = dao.searchAlarmMemberKindCode(receiverId,"ak1");		//ģ�� ��û : ak1
		ArrayList<FriendProposal> friendProposalList = new ArrayList<FriendProposal>();

		if(dto.size() != 0){
			System.out.println("�����Կ� �޽����� ����");
			//������ ���� ��� ���� ������.(�Ѹ��Ѹ�)
			for(AlarmDTO alarmDTO : dto)
			{
				//�۽����� ������ �������� ���� ����
				MemberManager memberManager = new MemberManager();
				Member member = memberManager.searchMemberCode(alarmDTO.getSenderCode());
				friendProposalList.add(new FriendProposal(member.getId(),member.getName()));
			}
			return friendProposalList;
		}
		else{
			System.out.println("������ �� �޽����� ����");
			return null;
		}
	}

	@Override
	public boolean requestFriendProposal(String senderId, String receiverId) {
		// TODO Auto-generated method stub
		DAOFactory factory = (DAOFactory)DAOFactory.getInstance();
		//senderId�� ����� receiverId �� ģ��
		//1.ģ���� �����ϴ��� Ȯ��
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(receiverId);
		
		//2.ģ���� ���� �Ѵٸ�.
		if(member.getId() != null)
		{			
			System.out.println("ģ���� ȸ����");
			String receiverCode = memberSearchable.searchMemberAdmin(receiverId).trim();
			//3.���� ���� ģ�������� �ִ��� Ȯ��
			if(searchFriendProposal(senderId, receiverCode)==null){
				System.out.println("���� ���´� ģ����û�� ����");
				//4. ģ�� ������ ã��
				FriendSearchable friendSearchable = new FriendManager();
				Friend friend= friendSearchable.searchFriendId(senderId, receiverCode);
				//5. ģ����û�޽��� ����
				if(friend.getFriendId() == null)
				{
					System.out.println("ģ���� �ƴϴ�.");
					AlarmMessageAlarmable alarmAble = new AlarmMessageManager();
					//senderId = "memberCode" receiverId = "receiverId
					if(alarmAble.alarmFriendRequest("ģ����û", receiverCode, senderId)){
						System.out.println("ģ����û �޽��� ��������");
						return true;
					}else{
						System.out.println("ģ����û�޽��� ��������");
						return false;
					}	
				}else{
					System.out.println("�̹� ģ���Դϴ�.Ż��");
					return false;
				}
			}else{
				System.out.println("�̹� ģ�� ������ ������. Ż��");
				return false;
			}
		}
		System.out.println("ģ���� ȸ���� �ƴ�");
		return false;
	}

	@Override
	public boolean requestFriendProposal(String adminId, String senderId,String receiverId) {
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
				//1.ģ���� �����ϴ��� Ȯ��
				MemberSearchable memberSearchable = new MemberManager();
				Member member = memberSearchable.searchMemberCode(receiverId);
				//2.ģ���� ���� �Ѵٸ�.
				if(member.getId() != null)
				{
					System.out.println("ģ���� ȸ����");
					//3.���� ���� ģ�������� �ִ��� Ȯ��
					if(searchFriendProposal(senderId, receiverId)==null){
						System.out.println("���� ���´� ģ����û�� ����");
						//4. ģ�� ������ ã��
						FriendSearchable friendSearchable = new FriendManager();
						Friend friend= friendSearchable.searchFriendId(senderId, receiverId);
						//5. ģ����û�޽��� ����
						if(friend.getFriendId() == null)
						{
							System.out.println("ģ���� �ƴϴ�.");
							AlarmMessageAlarmable alarmMessageAlarmable = new AlarmMessageManager();
							if(alarmMessageAlarmable.alarmFriendRequest("ģ����û", receiverId, senderId)){
								System.out.println("ģ����û �޽��� ��������");
								return true;
							}else{
								System.out.println("ģ����û�޽��� ��������");
								return false;
							}	
						}else{
							System.out.println("�̹� ģ���Դϴ�.Ż��");
							return false;
						}
					}else{
						System.out.println("�̹� ģ�� ������ ������. Ż��");
						return false;
					}
				}else{
					System.out.println("ģ���� ȸ���� �ƴ�");
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
}
