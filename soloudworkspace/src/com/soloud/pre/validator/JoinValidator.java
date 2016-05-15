package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.JoinForm;

public class JoinValidator {
	private ArrayList<String> errors;

	public JoinValidator() {
		this.errors = new ArrayList<String>();
	}

	public JoinValidator(ArrayList<String> errors) {
		this.errors = errors;
	}
	/**
	 * ���̵� �ߺ� �� �̸��� ���� üũ
	 * @param joinForm
	 */
	public void validateDup(JoinForm joinForm){
		// ���Է� �˻�(���̵�)
		if(joinForm.getId()==null || joinForm.getId().equals("")){
			this.errors.add("���̵� ���Է�");
			return;
		}
		
		//���̵� ���� �˻�(Ư������)
		if(joinForm.getId().indexOf("!")>=0 || joinForm.getId().indexOf("@")>=0 || joinForm.getId().indexOf("#")>=0 || joinForm.getId().indexOf("$")>=0 || joinForm.getId().indexOf("%")>=0 || joinForm.getId().indexOf("^")>=0 || joinForm.getId().indexOf("&")>=0 || joinForm.getId().indexOf("*")>=0 || joinForm.getId().indexOf("(")>=0 || joinForm.getId().indexOf(")")>=0 || joinForm.getId().indexOf("`")>=0 || joinForm.getId().indexOf("~")>=0 || joinForm.getId().indexOf("/")>=0 || joinForm.getId().indexOf("\\")>=0 || joinForm.getId().indexOf("=")>=0 || joinForm.getId().indexOf("+")>=0 || joinForm.getId().indexOf("|")>=0 || joinForm.getId().indexOf("<")>=0 || joinForm.getId().indexOf(">")>=0 || joinForm.getId().indexOf(",")>=0 || joinForm.getId().indexOf(".")>=0 || joinForm.getId().indexOf("?")>=0 || joinForm.getId().indexOf("-")>=0 || joinForm.getId().indexOf(":")>=0 || joinForm.getId().indexOf(";")>=0 || joinForm.getId().indexOf("[")>=0 || joinForm.getId().indexOf("]")>=0 || joinForm.getId().indexOf("{")>=0 || joinForm.getId().indexOf("}")>=0 || joinForm.getId().indexOf("\"")>=0 || joinForm.getId().indexOf("'")>=0 || joinForm.getId().indexOf("_")>=0){
			this.errors.add("���̵� ���� ����");
			return;
		}
		// ���Է� �˻�(������)
		if(joinForm.getDomain()==null || joinForm.getDomain().equals("")){
			this.errors.add("�̸��� ���Է�");
			return;
		}
		
		// ������ ���� �˻�(����)
		if(joinForm.getDomain().length()<6){
			this.errors.add("�̸��� ���� ����");
			return;
		}
		
		// ������ ���� �˻�
		String dotcom = joinForm.getDomain().substring(joinForm.getDomain().length()-4);
		String dotcokr = joinForm.getDomain().substring(joinForm.getDomain().length()-6);
		String dotnet = joinForm.getDomain().substring(joinForm.getDomain().length()-4);	
			
		if(!(dotcom.equals(".com") || dotcokr.equals(".co.kr") || dotnet.equals(".net"))){
			this.errors.add("�̸��� ���� ����");		
			return;
		}
		
	}
	/**
	 * ȸ������ ��ȿ�� üũ
	 * @param joinForm
	 */
	public void validateJoin(JoinForm joinForm){
		if(joinForm.getName()==null){
			this.errors.add("�ùٸ� �̸��� �Է��ϼ���");
			return;
		}
		if(joinForm.getPassword()==null){
			this.errors.add("�ùٸ� ��й�ȣ�� �Է��ϼ���");
			return;
		}
		if(joinForm.getRePassword()==null){
			this.errors.add("�ùٸ� ��й�ȣ�� �Է��ϼ���");
			return;
		}
		if(joinForm.getName().length()<2){
			this.errors.add("�ùٸ� �̸��� �Է��ϼ���");
			return;
		}
		if(joinForm.getPassword().length()<4 || joinForm.getPassword().length()>16){
			this.errors.add("�ùٸ� ��й�ȣ�� �Է��ϼ���");
			return;
		}
		if(joinForm.getRePassword().length()<4 || joinForm.getRePassword().length()>16){
			this.errors.add("�ùٸ� ��й�ȣ�� �Է��ϼ���");
			return;
		}
		if(!joinForm.getPassword().equals(joinForm.getRePassword())){
			this.errors.add("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return;
		}
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	
}
