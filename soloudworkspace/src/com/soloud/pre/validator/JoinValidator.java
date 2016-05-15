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
	 * 아이디 중복 및 이메일 형식 체크
	 * @param joinForm
	 */
	public void validateDup(JoinForm joinForm){
		// 미입력 검사(아이디)
		if(joinForm.getId()==null || joinForm.getId().equals("")){
			this.errors.add("아이디 미입력");
			return;
		}
		
		//아이디 형식 검사(특수문자)
		if(joinForm.getId().indexOf("!")>=0 || joinForm.getId().indexOf("@")>=0 || joinForm.getId().indexOf("#")>=0 || joinForm.getId().indexOf("$")>=0 || joinForm.getId().indexOf("%")>=0 || joinForm.getId().indexOf("^")>=0 || joinForm.getId().indexOf("&")>=0 || joinForm.getId().indexOf("*")>=0 || joinForm.getId().indexOf("(")>=0 || joinForm.getId().indexOf(")")>=0 || joinForm.getId().indexOf("`")>=0 || joinForm.getId().indexOf("~")>=0 || joinForm.getId().indexOf("/")>=0 || joinForm.getId().indexOf("\\")>=0 || joinForm.getId().indexOf("=")>=0 || joinForm.getId().indexOf("+")>=0 || joinForm.getId().indexOf("|")>=0 || joinForm.getId().indexOf("<")>=0 || joinForm.getId().indexOf(">")>=0 || joinForm.getId().indexOf(",")>=0 || joinForm.getId().indexOf(".")>=0 || joinForm.getId().indexOf("?")>=0 || joinForm.getId().indexOf("-")>=0 || joinForm.getId().indexOf(":")>=0 || joinForm.getId().indexOf(";")>=0 || joinForm.getId().indexOf("[")>=0 || joinForm.getId().indexOf("]")>=0 || joinForm.getId().indexOf("{")>=0 || joinForm.getId().indexOf("}")>=0 || joinForm.getId().indexOf("\"")>=0 || joinForm.getId().indexOf("'")>=0 || joinForm.getId().indexOf("_")>=0){
			this.errors.add("아이디 형식 오류");
			return;
		}
		// 미입력 검사(도메인)
		if(joinForm.getDomain()==null || joinForm.getDomain().equals("")){
			this.errors.add("이메일 미입력");
			return;
		}
		
		// 도메인 형식 검사(길이)
		if(joinForm.getDomain().length()<6){
			this.errors.add("이메일 형식 오류");
			return;
		}
		
		// 도메인 형식 검사
		String dotcom = joinForm.getDomain().substring(joinForm.getDomain().length()-4);
		String dotcokr = joinForm.getDomain().substring(joinForm.getDomain().length()-6);
		String dotnet = joinForm.getDomain().substring(joinForm.getDomain().length()-4);	
			
		if(!(dotcom.equals(".com") || dotcokr.equals(".co.kr") || dotnet.equals(".net"))){
			this.errors.add("이메일 형식 오류");		
			return;
		}
		
	}
	/**
	 * 회원가입 유효성 체크
	 * @param joinForm
	 */
	public void validateJoin(JoinForm joinForm){
		if(joinForm.getName()==null){
			this.errors.add("올바른 이름을 입력하세요");
			return;
		}
		if(joinForm.getPassword()==null){
			this.errors.add("올바른 비밀번호를 입력하세요");
			return;
		}
		if(joinForm.getRePassword()==null){
			this.errors.add("올바른 비밀번호를 입력하세요");
			return;
		}
		if(joinForm.getName().length()<2){
			this.errors.add("올바른 이름을 입력하세요");
			return;
		}
		if(joinForm.getPassword().length()<4 || joinForm.getPassword().length()>16){
			this.errors.add("올바른 비밀번호를 입력하세요");
			return;
		}
		if(joinForm.getRePassword().length()<4 || joinForm.getRePassword().length()>16){
			this.errors.add("올바른 비밀번호를 입력하세요");
			return;
		}
		if(!joinForm.getPassword().equals(joinForm.getRePassword())){
			this.errors.add("비밀번호가 일치하지 않습니다.");
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
