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
			this.errors.add("ģ����û ���� �ϴ� ���̵� ���� ���Է�");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("ģ����û ���� ���̵� ���� ���Է�");
		}
	}
	public void validateRefuse(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("ģ����û ���� �ϴ� ���̵� ���� ���Է�");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("ģ����û ���� ���̵� ���� ���Է�");
		}
	}
	public void validateCancel(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("ģ����û �޴� ���̵� ���� ���Է�");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("ģ����û ����ϴ� ���̵� ���� ���Է�");
		}
	}
	public void validateSearch(FriendProposalManageForm friendProposalManageForm)
	{
		if(friendProposalManageForm.getReceiveId().equals(""))
		{
			this.errors.add("ģ����û �޴� ���̵� ���� ���Է�");
		}
		if(friendProposalManageForm.getSenderId().equals(""))
		{
			this.errors.add("ģ����û ���� ���̵� ���� ���Է�");
		}
	}
}
