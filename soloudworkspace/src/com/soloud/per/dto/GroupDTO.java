package com.soloud.per.dto;
/**
 * 그룹정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 그룹의 고유한 코드
	 */
	private String groupCode;
	/**
	 * 사용자 코드
	 */
	private String memberCode;
	/**
	 * 그룹이름
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
