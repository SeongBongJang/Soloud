package com.soloud.app.man;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.manInt.SharedFolderFriendSearchable;
import com.soloud.app.manInt.SharedFolderSearchable;
import com.soloud.app.model.Friend;
import com.soloud.app.model.Member;
import com.soloud.app.model.Reply;
import com.soloud.app.model.SharedFolder;
import com.soloud.per.dao.FolderSearchDAO;
import com.soloud.per.dao.ReplyInsertDAO;
import com.soloud.per.dao.SharedFolderReplyVDAO;
import com.soloud.per.dao.SharedFolderSearchDAO;
import com.soloud.per.dto.FolderDTO;
import com.soloud.per.dto.SharedFolderDTO;
import com.soloud.per.dto.SharedFolderReplyVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;

public class SharedFolderReplyManager extends AbstractSharedFolderReplyManager {

	@Override
	public boolean addReply(String sharedFolderCode, String writerId,
			String content, GregorianCalendar writeDate) {
		// TODO Auto-generated method stub
		if(sharedFolderCode == null || writerId == null || content == null){return false;}
		
		//1.�ۼ��ڰ� ȸ������ �˻�
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(writerId);
		String memberCode = memberSearchable.searchMemberAdmin(writerId);
		System.out.println("�Ŵ��� �����ü �˻� : "+member);
		if(member == null){return false;}
		

		String folderCode = sharedFolderCode;
		//2.�������� �ڵ尡 ��ȿ���� �˻�
		/*SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(sharedFolderCode);
		System.out.println("�Ŵ��� ���� �˻� : "+sharedFolder);
		if(sharedFolder == null){return false;}*/
		
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderSearchDAO folderDAO = (FolderSearchDAO)factory.create("Folder");
		FolderDTO folderDTO = folderDAO.searchFolderCode(folderCode);
		String checkMemberCode = folderDTO.getMemberCode();
		System.out.println("üũ����ڵ� : "+checkMemberCode);
		
		
		SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(folderCode);
		String realSharedFolderCode = sharedFolder.getSharedFolderCode(); 
		System.out.println("�������ڵ�:"+realSharedFolderCode);
		
		//3.������������ ���� ������� �˻�(ȣ��Ʈ, �ʴ������� ����)
		if(!memberCode.equals(checkMemberCode)) {
			SharedFolderFriendSearchable sharedFolderFriendSearchable = new SharedFolderFriendManager();
			ArrayList<Friend> myFriendList = sharedFolderFriendSearchable.searchFolderFriend(realSharedFolderCode);
			if(myFriendList == null || myFriendList.isEmpty()){
				return false;
			}
			for(Friend temp : myFriendList){
				if(temp.getFriendId().equals(writerId)){
					break;//�������� ģ����Ͽ��� Ȯ�εǸ� �극��ũ
				} else {
					continue;
				}
			}
		}
		//4.����������۸�Ͽ� ��� �߰�
		ReplyInsertDAO replyInsertDAO = (ReplyInsertDAO)factory.create("Reply");
		if(replyInsertDAO.insertReply(realSharedFolderCode, memberCode, new GregorianCalendar(), content)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addReply(String adminId, String sharedFolderCode,
			String writerId, String content, GregorianCalendar writeDate) {
		return addReply(sharedFolderCode, writerId, content, writeDate);
	}

	@Override
	public Reply searchReply(String sharedFolderCode, String writerId,
			GregorianCalendar writeDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reply> searchReply(String sharedFolderCode, String writerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reply> searchReply(String sharedFolderCode,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reply> searchReply(String folderCode) {//�� �������ڴ� ��� �׳� �����ڵ�
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		
		//�θ��� �θ��� �θ��� .... �θ������ڵ尡 root�� �����ڵ带 ã�� �� �ڵ忡 ���εǴ� sf�� ã�� 
		//�� sf�� reply����� ����
		FolderSearchDAO folderSearchDAO = (FolderSearchDAO)factory.create("Folder");
		String curFolderCode = folderCode;
		System.out.println(folderCode);
		String resultCode = null;
		while(true) {
			String firstParent = folderSearchDAO.searchFolderCode(curFolderCode).getParentFolderCode();
			System.out.println(firstParent);
			
			String secondParent = folderSearchDAO.searchFolderCode(firstParent).getParentFolderCode();
			System.out.println(secondParent);
			if(secondParent.trim().equals("root")) {
				resultCode = curFolderCode;
				break;
			} 

			String thirdParent = folderSearchDAO.searchFolderCode(secondParent).getParentFolderCode();
			System.out.println(thirdParent);
			if(thirdParent == null || thirdParent.trim().equals("root") ) {
				resultCode = firstParent;
				break;
			} else {
				curFolderCode = firstParent;
			}
		}
		folderCode = resultCode;
		
		
		
		
		SharedFolderDTO sharedFolderDTO = sharedFolderSearchDAO.searchFolderCode(folderCode);
		String sharedFolderCode = sharedFolderDTO.getSharedFolderCode();//�� �ڵ尡 ��¥ �������ڵ�
		
		SharedFolderReplyVDAO sharedFolderReplyVDAO = (SharedFolderReplyVDAO)factory.create("SharedFolderReplyView");
		List<SharedFolderReplyVDTO> replyList = sharedFolderReplyVDAO.searchSharedFolderReply(sharedFolderCode);
		
		if(replyList == null || replyList.isEmpty()) {
			return null;
		}
		
		ArrayList<Reply> returnList = new ArrayList<Reply>();
		for(SharedFolderReplyVDTO temp : replyList) {
			String memberCode = temp.getMemberCode();
			MemberSearchable memberSearchable = new MemberManager();
			Member member = memberSearchable.searchMemberCode(memberCode);
			String writerId = member.getId();
			returnList.add(new Reply(writerId, temp.getReplyContent(), temp.getReplyWriteDate()));
		}
		return returnList;
	}

	@Override
	public boolean deleteReply(String sharedFolderCode, String writerId,
			GregorianCalendar writeDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReply(String adminId, String sharedFolderCode,
			String writerId, GregorianCalendar writeDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
