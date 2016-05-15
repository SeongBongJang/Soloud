package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.LoginForm;

public class LoginValidator {
	private ArrayList<String> errors;

	public LoginValidator(ArrayList<String> errors) {
		this.errors = errors;
	}

	public LoginValidator() {
		this(new ArrayList<String>());
	}
	/**
	 * �α��� ��ȿ�� üũ
	 * @param loginForm
	 */
	public void validateLogin(LoginForm loginForm){
		String id = loginForm.getId();
		if(id == null || id.trim().isEmpty() ){
			errors.add("���̵� �Է��ϼ���");
		}
		String password = loginForm.getPassword();
		if(password == null || password.trim().isEmpty()){
			errors.add("��й�ȣ�� �Է��ϼ���");
		} 
	}
	
	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "LoginValidator [errors=" + errors + "]";
	}
	
}
