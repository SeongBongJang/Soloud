package com.soloud.per.dao;

import com.soloud.per.dto.MemberLimitCapacityVDTO;

public interface MemberLimitCapacityVDAO 
{
	public MemberLimitCapacityVDTO searchMemberCapacityMemberCode(String memberCode);
	public MemberLimitCapacityVDTO searchMemberCapacityMemberId(String memberId);
}
