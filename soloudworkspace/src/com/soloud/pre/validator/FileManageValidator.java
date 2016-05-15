package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.FileManageForm;
import com.soloud.pre.uiform.FileSearchForm;
/**
 * 파일 관리 유효성 검사
 * @author 영진
 *
 */
public class FileManageValidator {
	private ArrayList<String> errors;

	public FileManageValidator() {
		this.errors = new ArrayList<String>();
	}

	public FileManageValidator(ArrayList<String> errors) {
		this.errors = errors;
	}
	/**
	 * 파일명 수정 시 유효성 검사
	 * @param fileForm
	 */
	public void validateName(FileManageForm fileForm){
		if(fileForm.getFileName().equals("")){
			errors.add("파일명 누락");
		}
	}
	/**
	 * 검색 시 유효성 검사
	 * @param fileSearchForm
	 */
	public void validateSearch(FileSearchForm fileSearchForm){
		if(fileSearchForm.getFileName().equals("")){
			errors.add("파일명 누락");
		}
	}
	/**
	 * 검색 시 유효성 검사
	 * @param fileSearchForm
	 */
	public void validateSearchAdmin(FileSearchForm fileSearchForm){
		if(fileSearchForm.getFileName().equals("")){
			errors.add("파일명 누락");
		}
		if(fileSearchForm.getFileType().equals("")){
			errors.add("유형 누락");
		}
	}
	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	
}
