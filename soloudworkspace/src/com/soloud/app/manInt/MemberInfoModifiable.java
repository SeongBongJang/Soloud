package com.soloud.app.manInt;

import com.soloud.app.model.Member;

public interface MemberInfoModifiable 
{
	public boolean modifyMemberInfo(Member member);
	public boolean modifyMemberInfo(String adminMemberCode, Member member);
	public boolean modifyMemberInfo(String memberCode, float limitCapacity);
}
