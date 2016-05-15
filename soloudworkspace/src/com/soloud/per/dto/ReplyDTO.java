package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * 댓글정보를 캡슐화 하고 있는 클래스
 * @author 장성봉
 *
 */
public class ReplyDTO 
{
	@Override
	public String toString() {
		return "ReplyDTO [replyCode=" + replyCode + ", sharedFolderCode="
				+ sharedFolderCode + ", memberCode=" + memberCode
				+ ", replyWriteDate=" + replyWriteDate + ", replyContent="
				+ replyContent + "]";
	}
	/**
	 * 댓글코드
	 */
	private String replyCode;
	/**
	 * 공유폴더코드
	 */
	private String sharedFolderCode;
	/**
	 * 사용자 멤버코드(작성한 사용자)
	 */
	private String memberCode;
	/**
	 * 댓글 작성일
	 */
	private GregorianCalendar replyWriteDate;
	/**
	 * 댓글 내용
	 */
	private String replyContent;
	public ReplyDTO(String replyCode, String sharedFolderCode,
			String memberCode, GregorianCalendar replyWriteDate,
			String replyContent) {
		super();
		this.replyCode = replyCode;
		this.sharedFolderCode = sharedFolderCode;
		this.memberCode = memberCode;
		this.replyWriteDate = replyWriteDate;
		this.replyContent = replyContent;
	}
	public ReplyDTO() {
		super();
	}
	public String getReplyCode() {
		return replyCode;
	}
	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}
	public String getSharedFolderCode() {
		return sharedFolderCode;
	}
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	
}
