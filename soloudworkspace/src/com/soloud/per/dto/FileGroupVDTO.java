package com.soloud.per.dto;
/**
 * �����ڵ忡 ���Ͽ� ���ٰ��� �׷��� ������ ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class FileGroupVDTO 
{
	@Override
	public String toString() {
		return "FileGroupVDTO [fileCode=" + fileCode + ", groupCode="
				+ groupCode + ", groupName=" + groupName + ", memberCode="
				+ memberCode + "]";
	}
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * �׷��ڵ�
	 */
	private String groupCode;
	/**
	 * �׷��̸�
	 */
	private String groupName;
	/**
	 * ����ڵ�
	 */
	private String memberCode;
	public FileGroupVDTO() {
		super();
	}
	public FileGroupVDTO(String fileCode, String groupCode, String groupName,
			String memberCode) {
		super();
		this.fileCode = fileCode;
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.memberCode = memberCode;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
}
