package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.Member;

public interface MemberSearchable 
{
	public ArrayList<Member> searchMember();
	public Member searchMemberCode(String memberCode);
	public Member searchMemberId(String memberId);
	public ArrayList<Member> searchMemberName(String name);
	public Member searchMember(String id, String password);
	public String searchMemberAdmin(String id);
}
