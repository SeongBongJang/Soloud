package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.FileManageForm;
import com.soloud.pre.uiform.FileSearchForm;
/**
 * ���� ���� ��ȿ�� �˻�
 * @author ����
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
	 * ���ϸ� ���� �� ��ȿ�� �˻�
	 * @param fileForm
	 */
	public void validateName(FileManageForm fileForm){
		if(fileForm.getFileName().equals("")){
			errors.add("���ϸ� ����");
		}
	}
	/**
	 * �˻� �� ��ȿ�� �˻�
	 * @param fileSearchForm
	 */
	public void validateSearch(FileSearchForm fileSearchForm){
		if(fileSearchForm.getFileName().equals("")){
			errors.add("���ϸ� ����");
		}
	}
	/**
	 * �˻� �� ��ȿ�� �˻�
	 * @param fileSearchForm
	 */
	public void validateSearchAdmin(FileSearchForm fileSearchForm){
		if(fileSearchForm.getFileName().equals("")){
			errors.add("���ϸ� ����");
		}
		if(fileSearchForm.getFileType().equals("")){
			errors.add("���� ����");
		}
	}
	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	
}
