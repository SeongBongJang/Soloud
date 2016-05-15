package com.soloud.per.dto;

public class MemberLimitCapacityVDTO 
{
	private String memberCode;
	private String memberId;
	private int usedCapacity;
	private int totalCapacity;
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getUsedCapacity() {
		return usedCapacity;
	}
	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public MemberLimitCapacityVDTO(String memberCode, String memberId,
			int usedCapacity, int totalCapacity) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.usedCapacity = usedCapacity;
		this.totalCapacity = totalCapacity;
	}
	public MemberLimitCapacityVDTO() {
		super();
	}
	
	
}
