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
		
		//���� �θ�������
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
		//���� �θ�������
		return false;
	}

	@Override
	//���⿡ ��ǲ�Ǵ� ����������� id �� ���� id ���� ����..!!! �ٸ��� �� code;;; �޼��尡 ������
	//���� id�־�ߵſ�!~
	public boolean modifyMemberInfo(Member member) {
		Factory factory = (Factory)DAOFactory.getInstance();
		
		MemberUpdateDAO dao = (MemberUpdateDAO)factory.create("Member");
		
		dao.updateMember(member.getId(), member.getName(), member.getPassword());
				
		return true;
	
	}

	@Override
	public boolean modifyMemberInfo(String adminMemberCode, Member member) {
		//���� �θ�������
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
		//��� ����ڵ带 �޾Ƽ� ���ǿ� �ø� �뵵��
		//����� ���̵� ����ڵ��ӽ�����
		
		m.setName(tmp.getMemberId());
		//��� ���̵�� �����ؼ� �������� �˻��ؼ� ����ڵ带 ã�� �뵵��
		//����� �̸��� ����� ���̵�(�̸���) �ӽ�����
		
		m.setPassword(tmp.getMemberKindCode());
		//�����δ� ���ī�ε��ڵ�Ѿ�� ���������� �ƴ��� �Ǻ�..��
		
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
