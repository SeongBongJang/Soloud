package com.soloud.pre.validator;

import java.util.ArrayList;

import com.soloud.pre.uiform.FriendProposalManageForm;

public class FriendProposalValidator {
	private ArrayList<String> errors;

	public FriendProposalValidator() {
	}

	public FriendProposalValidator(ArrayList<String> errors) {
		this.errors = errors;
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	public void validateAccept(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("친구신청 수락 하는 아이디 정보 미입력");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("친구신청 보낸 아이디 정보 미입력");
		}
	}
	public void validateRefuse(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("친구신청 거절 하는 아이디 정보 미입력");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("친구신청 보낸 아이디 정보 미입력");
		}
	}
	public void validateCancel(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("친구신청 받는 아이디 정보 미입력");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("친구신청 취소하는 아이디 정보 미입력");
		}
	}
	public void validateSearch(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("친구신청 받는 아이디 정보 미입력");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("친구신청 보낸 아이디 정보 미입력");
		}
	}
}
