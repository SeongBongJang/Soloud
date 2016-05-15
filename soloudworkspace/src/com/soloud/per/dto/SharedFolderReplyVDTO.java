package com.soloud.per.dto;
import java.util.GregorianCalendar;
/**
 * ���������� ���� ��������� ĸ��ȭ�� Ŭ����
 * @author �强��
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
	 * �������� �ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * ��� �ڵ�
	 */
	private String replyCode;
	/**
	 * ����� ��� �ڵ�
	 */
	private String memberCode;
	/**
	 * ����� ����̸�
	 */
	private String memberName;
	/**
	 * ��� �ۼ���
	 */
	private GregorianCalendar replyWriteDate;
	/**
	 * ��� ����
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
