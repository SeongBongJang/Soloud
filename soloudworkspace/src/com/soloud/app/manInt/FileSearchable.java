package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.File;
import com.soloud.app.model.FileList;

public interface FileSearchable {
	/**
	 * 모든 파일종류, 모든 등록기간에 해당하는 모든 파일 검색 (관리자)
	 * @return
	 */
	public ArrayList<File> searchAllFile();
	/**
	 * 해당 파일 종류, 모든 등록기간에 해당하는 파일명 검색 (관리자)
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchAllFileTypeName(String fileType, String fileName);
	/**
	 * 해당 등록기간, 모든 파일 종류에 해당하는 파일명 검색 (관리자)
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public ArrayList<File> searchAllFileDateName(int underDate, String fileName);
	/**
	 * 해당 파일 종류, 해당 등록기간에 해당하는 파일명 검색 (관리자)
	 * @param fileType
	 * @param underDate
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchAllFile(String fileType, int underDate, String fileName);
	/**
	 * 회원 파일 범주에서 회원의 모든 파일을 검색
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchFile(String id);
	/**
	 * 회원 파일 범주에서 파일 종류에 따른 검색
	 * @param id
	 * @param filePath
	 * @return
	 */
	public ArrayList<File> searchFileType(String id, String fileType);
	/**
	 * 회원 파일 범주에서 파일 이름에 따른 모든 종류의 파일 검색
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchMyFileName(String id, String fileName);
	/**
	 * 회원 파일 범주에서 업로더 이름이 포함되는 파일 검색
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchMyFileUploaderName(String id, String uploaderName);
	/**
	 * 회원 파일 범주에서 업로더 이름이 포함되고 파일 타입이 일치하는 파일 검색
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileUploaderType(String id, String uploaderName, String fileType);
	/**
	 * 회원 파일 범주에서 파일 타입이 일치하는 파일 검색
	 * @param id
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileType(String id, String fileType);
	/**
	 * 회원 파일 범주에서 파일 종류와 파일 이름에 따른 파일 검색
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileNameType(String id, String fileName, String fileType);
	/**
	 * 해당 파일 코드에 따른 검색
	 * @param id
	 * @param fileCode
	 * @return
	 */
	public File searchFileCode(String id, String fileCode);
	/**
	 * 모든 파일 범주에서 파일명과 파일종류에 따른 검색
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileNameType(String id, String fileName, String fileType);
	/**
	 * 모든 파일 범주에서 업로더 이름과 파일종류에 따른 검색
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileUploaderNameType(String id, String uploaderName, String fileType);
	/**
	 * 모든 파일 범주에서 업로드 이름과 모든 파일종류에 따른 검색
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchFileUploaderName(String id, String uploaderName);
	/**
	 * 모든 파일 범주에서 업로더 아이디와 파일종류에 따른 검색
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileUploaderIdType(String id, String uploaderId, String fileType);
	/**
	 * 모든 파일 범주에서 업로더 아이디와 모든 파일종류에 따른 검색
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchFileUploaderId(String id, String uploaderId);
	/**
	 * 모든 파일 범주에서 파일 이름에 따른 모든 종류의 파일 검색
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchFileName(String id, String fileName);
	/**
	 * 해당 폴더 코드를 갖는 모든 파일을 검색
	 * @param id
	 * @param folderCode
	 * @return
	 */
	public ArrayList<File> searchFolderCode(String id, String folderCode);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아닌 모든 파일을 검색함
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFile(String id);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아닌 모든 파일중 해당 타입의 파일 검색
	 * @param id
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileType(String id, String fileType);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 해당 이름이 들어가는 파일 검색
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchSharedFileName(String id, String fileName);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 해당 이름이 들어가며
	 * 해당 파일 타입의 파일 검색
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileNameType(String id, String fileName, String fileType);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고 
	 * 나와 이름이 같은 업로더를 포함한 모든 친구의 파일 검색 
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderName(String id, String uploaderName);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내가 업로더가 아니고
	 * 나와 이름이 같은 업로더를 포함하며 해당 파일 타입의 파일 검색
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderNameType(String id, String uploaderName, String fileType);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내 아이디가 아닌 다른 업로더의 파일 검색
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderId(String id, String uploaderId);
	/**
	 * 내가 호스트이거나 초대된 공유폴더의 모든 파일들 중 내 아이디가 아닌 다른 업로더의 파일중에서
	 * 해당 파일 타입의 파일 검
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderIdType(String id, String uploaderId, String fileType);
}
