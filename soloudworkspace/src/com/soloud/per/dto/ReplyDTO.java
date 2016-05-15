package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ��������� ĸ��ȭ �ϰ� �ִ� Ŭ����
 * @author �强��
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
	 * ����ڵ�
	 */
	private String replyCode;
	/**
	 * ���������ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * ����� ����ڵ�(�ۼ��� �����)
	 */
	private String memberCode;
	/**
	 * ��� �ۼ���
	 */
	private GregorianCalendar replyWriteDate;
	/**
	 * ��� ����
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
