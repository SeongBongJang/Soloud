package com.soloud.app.manInt;

import com.soloud.app.model.Member;

public interface MemberJoinable 
{
	public boolean joinMember(Member member);
	public boolean joinMember(String adminMemberCode, Member member);
}
