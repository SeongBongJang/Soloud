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
			this.errors.add("삭제 아이디 정보 미입력");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("삭제 할 아이디의 그룹정보 미입력");
		}
		return;
	}
	public void validateModify(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("수정 아이디 정보 미입력");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("수정 할 아이디의 그룹정보 미입력");
		}
		return;
	}
	public void validateRequest(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("요청 아이디 정보 미입력");
		}
		if(friendMangeForm.getNewGroup().equals(""))
		{
			this.errors.add("요청 할 아이디의 그룹정보 미입력");
		}
		return;
	}
	public void validateSearch(FriendManageForm friendMangeForm)
	{
		if(friendMangeForm.getFriendId().equals(""))
		{
			this.errors.add("검색 아이디 정보 미입력");
		}
		return;
	}
	
	
	
	
}
