package com.soloud.app.man;

import java.util.ArrayList;
import java.util.List;

import com.soloud.app.model.Member;
import com.soloud.per.dao.MemberDeleteDAO;
import com.soloud.per.dao.MemberInsertDAO;
import com.soloud.per.dao.MemberLimitCapacityVDAO;
import com.soloud.per.dao.MemberSearchDAO;
import com.soloud.per.dao.MemberUpdateDAO;
import com.soloud.per.dto.MemberDTO;
import com.soloud.per.dto.MemberLimitCapacityVDTO;
import com.soloud.per.factory.DAOFactory;
import com.soloud.per.factory.Factory;

public class MemberManager extends AbstractMemberManager
{

	@Override
	public ArrayList<Member> searchMember() 
	{
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		ArrayList<Member> temp = new ArrayList<Member>();
		List<MemberDTO> list = dao.searchAllMember();
		
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
		for(MemberDTO tmp : list)
		{
			Member m = new Member();
			m.setId(tmp.getMemberId());
			m.setName(tmp.getName());
			m.setPassword(tmp.getPassword());
			MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId());
			m.setCapacityLimit(Float.parseFloat(""+tmp.getMemberLimitCapacity()));
			m.setUsedCapacity(t.getUsedCapacity());
			
			temp.add(m);
		}
		return temp;
	}

	@Override
	public Member searchMemberCode(String memberCode) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		MemberDTO tmp = dao.searchMemberCode(memberCode);
		System.out.println(memberCode);
		System.out.println(tmp);
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
		
	
		Member m = new Member();
		m.setId(tmp.getMemberId().trim());
		System.out.println(tmp.getMemberId().trim());
		m.setName(tmp.getName().trim());
		MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId().trim());
	//	System.out.println(t);
		m.setCapacityLimit(t.getTotalCapacity());
		m.setUsedCapacity(t.getUsedCapacity());
		
			
		return m;
	}

	@Override
	public Member searchMemberId(String memberId) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		System.out.println(memberId);
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		System.out.println(memberId);
		MemberDTO tmp = dao.searchMemberId(memberId);
		System.out.println(tmp);
		
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
		
	
		Member m = new Member();
		m.setId(tmp.getMemberId());
		m.setName(tmp.getName());
		System.out.println(m.getId());
		MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId());
		m.setCapacityLimit(t.getTotalCapacity());
		m.setUsedCapacity(t.getUsedCapacity());
		
			
		return m;
	}

	@Override
	public ArrayList<Member> searchMemberName(String name) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		ArrayList<Member> temp = new ArrayList<Member>();
		List<MemberDTO> list = dao.searchMemberName(name);
		
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
		for(MemberDTO tmp : list)
		{
			Member m = new Member();
			m.setId(tmp.getMemberId());
			m.setName(tmp.getName());
			MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId());
			m.setCapacityLimit(t.getTotalCapacity());
			m.setUsedCapacity(t.getUsedCapacity());
			temp.add(m);
		}
		return temp;
	}

	@Override
	public Member searchMember(String id, String password) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		MemberDTO tmp = dao.searchMemberIdPwd(id, password);
		
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
		
	
		Member m = new Member();
		m.setId(tmp.getMemberId());
		m.setName(tmp.getName());
		MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId());
		m.setCapacityLimit(t.getTotalCapacity());
		m.setUsedCapacity(t.getUsedCapacity());
		
			
		return m;
	}

	@Override
	public boolean dropMember(String memberCode) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberDeleteDAO dao = (MemberDeleteDAO)factory.create("Member");
		
		int tmp = dao.deleteMemberCode(memberCode);
		
		if(tmp>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean dropMember(String adminMemberCode, String memberCode) {
		// TODO Auto-generated method stub
		
		//객기 부리지마라
		return false;
	}

	@Override
	public boolean joinMember(Member member) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberInsertDAO dao = (MemberInsertDAO)factory.create("Member");
		
		boolean tmp = dao.insertMember(member.getId(), member.getCapacityLimit(), member.getPassword(), member.getName());
		
		return tmp;
	}

	@Override
	public boolean joinMember(String adminMemberCode, Member member) {
		// TODO Auto-generated method stub
		//객기 부리지마라
		return false;
	}

	@Override
	//여기에 인풋되는 멤버정보에서 id 는 실제 id 값이 맞음..!!! 다른건 다 code;;; 메서드가 업성서
	//실제 id넣어야돼욤!~
	public boolean modifyMemberInfo(Member member) {
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberUpdateDAO dao = (MemberUpdateDAO)factory.create("Member");
		
		dao.updateMember(member.getId(), member.getName(), member.getPassword());
				
		return true;
	
	}

	@Override
	public boolean modifyMemberInfo(String adminMemberCode, Member member) {
		//객기 부리지마라
		return false;
	}

	@Override
	public boolean loginMember(String id, String password) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberSearchDAO dao = (MemberSearchDAO)factory.create("Member");
		
		MemberDTO tmp = dao.searchMemberIdPwd(id, password);
		
		MemberLimitCapacityVDAO dao2 = (MemberLimitCapacityVDAO) factory.create("MemberLimitCapacityView");
		
		
	
		Member m = new Member();
		m.setId(tmp.getMemberId());
		m.setName(tmp.getName());
		MemberLimitCapacityVDTO t = dao2.searchMemberCapacityMemberId(m.getId());
		m.setCapacityLimit(t.getTotalCapacity());
		m.setUsedCapacity(t.getUsedCapacity());
		
		
		m.setId(tmp.getMemberCode());
		//얘는 멤버코드를 받아서 세션에 올릴 용도임
		//멤버의 아이디에 멤버코드임시저장
		
		m.setName(tmp.getMemberId());
		//얘는 아이디로 저장해서 서블릿에서 검색해서 멤버코드를 찾을 용도임
		//멤버의 이름에 멤버의 아이디(이메일) 임시저장
		
		m.setPassword(tmp.getMemberKindCode());
		//실제로는 멤버카인드코드넘어가서 관리자인지 아닌지 판별..ㅠ
		
		//m.set
		
		if(m.getId()==null)
		{
			return false;
		}
		else
		{
			AbstractMemberManager.getMemberList().addMember(m);
			return true;
		}
	}

	@Override
	public String searchMemberAdmin(String id) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		MemberSearchDAO memberSearchDAO = (MemberSearchDAO)factory.create("Member");
		String code = memberSearchDAO.searchMemberAdmin(id).trim();
		return code;
	}

	@Override
	public boolean modifyMemberInfo(String memberCode, float limitCapacity) {
		// TODO Auto-generated method stub
		Factory factory = (Factory)DAOFactory.getInstance();
		MemberUpdateDAO memberUpdateDAO = (MemberUpdateDAO)factory.create("Member");
		int res = memberUpdateDAO.updateMemberLimitCapacity(memberCode, limitCapacity);
		if(res != 0){
			return true;
		} else return false;
	}

}
