package com.soloud.per.dao;

import java.util.List;

import com.soloud.per.dto.FolderCapacityVDTO;

public interface FolderCapacityVDAO
{
	public List<FolderCapacityVDTO> searchAllFolderCapacity();
	public FolderCapacityVDTO searchFolderCapacity(String folderCode);
}
