package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * 파일클래스의 목록형 클래스
 * @author oong
 *
 */
public class FileList implements Serializable{
	/**
	 * 시리얼버전 아이디
	 */
	private static final long serialVersionUID = 6902577063100753398L;

	/**
	 * 파일의 목록
	 */
	public ArrayList<File> files;
	
	
	/**
	 * 파일리스트 클래스 기본생성자
	 */
	public FileList() {
		this(new ArrayList<File>());
	}
	/**
	 * 파일리스트 클래스 오버로딩 생성자
	 * @param files 파일목록
	 */
	public FileList(ArrayList<File> files) {
		this.files = files;
	}

	/**
	 * 파일을 목록에 추가하기위한 메소드
	 * @param file 파일객체
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false리턴
	 */
	public boolean addFile(File file) {
		return files.add(file);
	}
	
	/**
	 * 파일을 목록에 추가하기위한 메소드
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param uploaderId 파일의 업로더 아이디
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, " ", new GregorianCalendar(), uploaderId));
	}
	
	/**
	 * 파일을 목록에 추가하기이 위한 메소드
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의 코멘트정보
	 * @param uploaderId 파일의 업로더 아이디
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String comment, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, comment, new GregorianCalendar(), uploaderId)); 
	}
	
	/**
	 * 파일을 목록에 추가하기위한 메소드
	 * @param accessAuth 파일의 접근권한
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param fileCapacity 파일의 용량
	 * @param fileType 파일의 유형
	 * @param comment 파일의 코멘트 정보
	 * @param lastModifyDate 파일의 마지막 등록일자
	 * @param uploaderId 파일의 업로더 아이디
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String comment, GregorianCalendar lastModifyDate, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, comment, lastModifyDate, uploaderId));
	}
	/**
	 * 파일을 목록에 추가하기위한 메소드 
	 * @param fileCode 파일의 식별코드
	 * @param folderCode 파일의 폴더코드
	 * @return 추가에 대한 성공여부. 성공시 true, 실패시 false 리턴
	 */
	public boolean addFile(String fileCode, String folderCode){
		return files.add(new File(fileCode, folderCode));
	}
	
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param folderCode 파일의 폴더코드
	 */
	public void deleteFolderCode(String folderCode){
		for(int i=0;i<this.files.size();i++){
			if(files.get(i).getFolderCode().equals(folderCode)){
				files.remove(i);
			}
		}
		
	}
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param fileCode 파일의 식별코드
	 */
	public void deleteFileCode(String fileCode){
		files.remove(searchFileCode(fileCode));
	}
	
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param fileName 파일명
	 * @param filePath 파일경로
	 * @param uploaderId 업로더아이디
	 */
	public void deleteFile(String fileName, String filePath, String uploaderId) {
		for(int i=0;i<this.files.size();i++){
			if(files.get(i).getFileName().equals(fileName) && files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				files.remove(i);
				return;
			}
		}
	}
	
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param filePath 파일의 경로
	 * @param uploaderId 파일의 업로더 아이디
	 */
	public void deleteFile(String filePath, String uploaderId) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				files.remove(i);
			}
		}
	}
	
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param uploaderId 파일의 업로더 아이디
	 */
	public void deleteFile(String uploaderId) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getUploaderId().equals(uploaderId)){
				files.remove(i);
			}
		}
	}
	
	/**
	 * 파일을 목록으로부터 삭제하기위한 메소드
	 * @param file 파일객체
	 */
	public void deleteFile(File file) {
		files.remove(file);
	}
	/**
	 * 파일의 정보를 수정하기위한 메소드
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @param newFileName 수정할 파일이름
	 */
	public void modifyFileName(String fileName, String filePath, String uploaderId, String newFileName) {
		searchFile(fileName, filePath, uploaderId).setFileName(newFileName);
	}
	
	/**
	 * 파일의 정보를 수정하기위한 메소드
	 * @param fileName 파일명
	 * @param filePath 파일경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @param newFilePath 수정할 파일의 경로
	 */
	public void modifyFilePath(String fileName, String filePath, String uploaderId, String newFilePath) {
		searchFile(fileName, filePath, uploaderId).setFilePath(newFilePath);
	}
	
	/**
	 * 파일의 정보를 수정하기위한 메소드
	 * @param fileName 파일명
	 * @param filePath 파일경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @param newComment 수정할  파일의 코멘트 정보
	 */
	public void modifyFileComment(String fileName, String filePath, String uploaderId, String newComment) {
		searchFile(fileName, filePath, uploaderId).setComment(newComment);
	}
	
	/**
	 * 파일의 정보를 수정하기위한 메소드
	 * @param filePath 파일의 경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @param newFilePath 수정할 파일의 경로
	 */
	public void modifyFilePathAll(String filePath, String uploaderId, String newFilePath) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				files.get(i).setFilePath(newFilePath);
			}
		}
	}
	
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileName 파일명
	 * @param filePath 파일의 경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @return File객체
	 */
	public File searchFile(String fileName, String filePath, String uploaderId) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getFileName().equals(fileName) && files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				return files.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 파일을 목록에서 검색하기 위한 메소드
	 * @param filePath 파일의 경로
	 * @param uploaderId 파일의 업로더 아이디
	 * @return File의 리스트. 데이터가 존재하지 않을 경우 null 리턴
	 */
	public ArrayList<File> searchFilePathId(String filePath, String uploaderId) {
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFilePath().equals(filePath) && this.files.get(i).getUploaderId().equals(uploaderId)){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	
	/**
	 * 파일을 목록에서 검색하기 위한 메소드
	 * @param uploaderId 파일의 업로더 아이디
	 * @return File의 리스트. 데이터가 존재하지 않을 경우 null 리턴
	 */
	public ArrayList<File> searchFileId(String uploaderId) {
		ArrayList<File> list = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getUploaderId().equals(uploaderId)){
				list.add(this.files.get(i));
			}
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileName 파일명
	 * @return File의 리스트. 데이터가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<File> searchFileName(String fileName) {
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFileName().equals(fileName)){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileName 파일명
	 * @param uploaderId 파일의 업로더 아이디
	 * @return File의 리스트. 데이터가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<File> searchFileNameId(String fileName, String uploaderId) {
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFileName().equals(fileName) && this.files.get(i).getUploaderId().equals(uploaderId)){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileType 파일의 유형
	 * @param uploaderId 파일의 업로더 아이디
	 * @return File의 리스트. 데이터가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<File> searchFileType(String fileType, String uploaderId) {
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFileType().equals(fileType) && this.files.get(i).getUploaderId().equals(uploaderId)){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileType
	 * @return File의 리스트. 데이터가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<File> searchFileTypeAll(String fileType) {
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFileType().equals(fileType) ){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param fileCode
	 * @return File객체. 존재하지않을 경우 null 리턴
	 */
	public File searchFileCode(String fileCode){
		for(int i=0;i<this.files.size();i++){
			if(files.get(i).getFileCode().equals(fileCode)){
				return files.get(i);
			}
		}
		return null;
	}
	/**
	 * 파일을 목록에서 검색하기위한 메소드
	 * @param folderCode
	 * @return File의 리스트. 데이터가 존재하지않을 경우 null 리턴
	 */
	public ArrayList<File> searchFolderCode(String folderCode){
		ArrayList<File> files = new ArrayList<File>();
		for(int i=0;i<this.files.size();i++){
			if(this.files.get(i).getFolderCode().equals(folderCode)){
				files.add(files.get(i));
			}
		}
		if(files.isEmpty()){
			return null;
		}
		return files;
	}
	/**
	 * getter
	 * @return 파일의 리스트
	 */
	public ArrayList<File> getFiles() {
		return files;
	}
	/**
	 * setter
	 * @param files 파일의 리스트
	 */
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
}
