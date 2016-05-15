package com.soloud.per.dto;
/**
 * �׷������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class GroupDTO 
{
	@Override
	public String toString() {
		return "GroupDTO [groupCode=" + groupCode + ", memberCode="
				+ memberCode + ", groupName=" + groupName + "]";
	}
	/**
	 * �׷��� ������ �ڵ�
	 */
	private String groupCode;
	/**
	 * ����� �ڵ�
	 */
	private String memberCode;
	/**
	 * �׷��̸�
	 */
	private String groupName;
	public GroupDTO(String groupCode, String memberCode, String groupName) {
		super();
		this.groupCode = groupCode;
		this.memberCode = memberCode;
		this.groupName = groupName;
	}
	public GroupDTO() {
		super();
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
