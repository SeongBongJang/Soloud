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
	 * 로그인 유효성 체크
	 * @param loginForm
	 */
	public void validateLogin(LoginForm loginForm){
		String id = loginForm.getId();
		if(id == null || id.trim().isEmpty() ){
			errors.add("아이디를 입력하세요");
		}
		String password = loginForm.getPassword();
		if(password == null || password.trim().isEmpty()){
			errors.add("비밀번호를 입력하세요");
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
