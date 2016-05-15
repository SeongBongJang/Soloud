package com.soloud.per.dao;

import java.util.List;

import com.soloud.per.dto.MemberShareFolderVDTO;


public interface MemberShareFolderVDAO 
{
	public List<MemberShareFolderVDTO> searchMemberShareFolder(String memberCode);
	public MemberShareFolderVDTO searchMemberShareFolderCode(String folderCode);	
}
