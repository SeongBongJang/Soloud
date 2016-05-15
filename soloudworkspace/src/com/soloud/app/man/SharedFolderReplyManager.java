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
		
		//1.작성자가 회원인지 검사
		MemberSearchable memberSearchable = new MemberManager();
		Member member = memberSearchable.searchMemberId(writerId);
		String memberCode = memberSearchable.searchMemberAdmin(writerId);
		System.out.println("매니저 멤버객체 검사 : "+member);
		if(member == null){return false;}
		

		String folderCode = sharedFolderCode;
		//2.공유폴더 코드가 유효한지 검사
		/*SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(sharedFolderCode);
		System.out.println("매니저 쉐폴 검사 : "+sharedFolder);
		if(sharedFolder == null){return false;}*/
		
		Factory factory = (Factory)DAOFactory.getInstance();
		FolderSearchDAO folderDAO = (FolderSearchDAO)factory.create("Folder");
		FolderDTO folderDTO = folderDAO.searchFolderCode(folderCode);
		String checkMemberCode = folderDTO.getMemberCode();
		System.out.println("체크멤버코드 : "+checkMemberCode);
		
		
		SharedFolderSearchable sharedFolderSearchable = new SharedFolderManager();
		SharedFolder sharedFolder = sharedFolderSearchable.searchSharedFolderCode(folderCode);
		String realSharedFolderCode = sharedFolder.getSharedFolderCode(); 
		System.out.println("리얼쉐폴코드:"+realSharedFolderCode);
		
		//3.공유폴더내에 속한 멤버인지 검사(호스트, 초대받은사람 무관)
		if(!memberCode.equals(checkMemberCode)) {
			SharedFolderFriendSearchable sharedFolderFriendSearchable = new SharedFolderFriendManager();
			ArrayList<Friend> myFriendList = sharedFolderFriendSearchable.searchFolderFriend(realSharedFolderCode);
			if(myFriendList == null || myFriendList.isEmpty()){
				return false;
			}
			for(Friend temp : myFriendList){
				if(temp.getFriendId().equals(writerId)){
					break;//공유폴더 친구목록에서 확인되면 브레이크
				} else {
					continue;
				}
			}
		}
		//4.공유폴더댓글목록에 댓글 추가
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
	public ArrayList<Reply> searchReply(String folderCode) {//이 전달인자는 사실 그냥 폴더코드
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		SharedFolderSearchDAO sharedFolderSearchDAO = (SharedFolderSearchDAO)factory.create("SharedFolder");
		
		//부모의 부모의 부모의 .... 부모폴더코드가 root인 폴더코드를 찾아 그 코드에 매핑되는 sf를 찾아 
		//그 sf의 reply목록을 리턴
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
		String sharedFolderCode = sharedFolderDTO.getSharedFolderCode();//이 코드가 진짜 쉐폴더코드
		
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
