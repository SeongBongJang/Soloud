package com.soloud.app.man;

import com.soloud.app.manInt.MemberDropable;
import com.soloud.app.manInt.MemberInfoModifiable;
import com.soloud.app.manInt.MemberJoinable;
import com.soloud.app.manInt.MemberLoginable;
import com.soloud.app.manInt.MemberSearchable;
import com.soloud.app.model.MemberList;

public abstract class AbstractMemberManager implements MemberSearchable, MemberDropable, MemberJoinable, MemberInfoModifiable, MemberLoginable
{
	private static MemberList memberList;

	
	static
	{
		AbstractMemberManager.memberList=new MemberList();
	}
	public static synchronized MemberList getMemberList() 
	{
		
		return AbstractMemberManager.memberList;
	}

	public static void setMemberList(MemberList memberList) 
	{
		AbstractMemberManager.memberList = memberList;
	}
	
	
}
