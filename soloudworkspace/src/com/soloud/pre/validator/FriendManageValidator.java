package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.FriendManageForm;

public class FriendManageValidator {
	private ArrayList<String> errors;

	public FriendManageValidator() {
		this(new ArrayList<String>());
	}

	public FriendManageValidator(ArrayList<String> errors) {
		this.errors = errors;
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	public void validateDrop(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("���� ���̵� ���� ���Է�");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("���� �� ���̵��� �׷����� ���Է�");
		}
		return;
	}
	public void validateModify(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("���� ���̵� ���� ���Է�");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("���� �� ���̵��� �׷����� ���Է�");
		}
		return;
	}
	public void validateRequest(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("��û ���̵� ���� ���Է�");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("��û �� ���̵��� �׷����� ���Է�");
		}
		return;
	}
	public void validateSearch(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("�˻� ���̵� ���� ���Է�");
		}
		return;
	}
	
	
	
	
}
