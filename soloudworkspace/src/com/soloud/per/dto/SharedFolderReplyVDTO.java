package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 공유폴더에 대한 댓글정보를 캡슐화한 클래스
 * @author 장성봉
 *
 */
public class SharedFolderReplyVDTO 
{
	@Override
	public String toString() {
		return "SharedFolderReplyVDTO [sharedFolderCode=" + sharedFolderCode
				+ ", replyCode=" + replyCode + ", memberCode=" + memberCode
				+ ", memberName=" + memberName + ", replyWriteDate="
				+ replyWriteDate + ", replyContent=" + replyContent + "]";
	}
	/**
	 * 공유폴더 코드
	 */
	private String sharedFolderCode;
	/**
	 * 댓글 코드
	 */
	private String replyCode;
	/**
	 * 사용자 멤버 코드
	 */
	private String memberCode;
	/**
	 * 사용자 멤버이름
	 */
	private String memberName;
	/**
	 * 댓글 작성일
	 */
	private GregorianCalendar replyWriteDate;
	/**
	 * 댓글 내용
	 */
	private String replyContent;
	public SharedFolderReplyVDTO(String sharedFolderCode, String replyCode,
			String memberCode, String memberName,
			GregorianCalendar replyWriteDate, String replyContent) {
		super();
		this.sharedFolderCode = sharedFolderCode;
		this.replyCode = replyCode;
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.replyWriteDate = replyWriteDate;
		this.replyContent = replyContent;
	}
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	public String getReplyCode() {
		return replyCode;
	}
	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public GregorianCalendar getReplyWriteDate() {
		return replyWriteDate;
	}
	public void setReplyWriteDate(GregorianCalendar replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public SharedFolderReplyVDTO() {
		super();
	}
	
	
}
