package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * ����Ŭ������ ����� Ŭ����
 * @author oong
 *
 */
public class FileList implements Serializable{
	/**
	 * �ø������ ���̵�
	 */
	private static final long serialVersionUID = 6902577063100753398L;

	/**
	 * ������ ���
	 */
	public ArrayList<File> files;
	
	
	/**
	 * ���ϸ���Ʈ Ŭ���� �⺻������
	 */
	public FileList() {
		this(new ArrayList<File>());
	}
	/**
	 * ���ϸ���Ʈ Ŭ���� �����ε� ������
	 * @param files ���ϸ��
	 */
	public FileList(ArrayList<File> files) {
		this.files = files;
	}

	/**
	 * ������ ��Ͽ� �߰��ϱ����� �޼ҵ�
	 * @param file ���ϰ�ü
	 * @return �߰��� ���� ��������. ������ true, ���н� false����
	 */
	public boolean addFile(File file) {
		return files.add(file);
	}
	
	/**
	 * ������ ��Ͽ� �߰��ϱ����� �޼ҵ�
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, " ", new GregorianCalendar(), uploaderId));
	}
	
	/**
	 * ������ ��Ͽ� �߰��ϱ��� ���� �޼ҵ�
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param comment ������ �ڸ�Ʈ����
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String comment, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, comment, new GregorianCalendar(), uploaderId)); 
	}
	
	/**
	 * ������ ��Ͽ� �߰��ϱ����� �޼ҵ�
	 * @param accessAuth ������ ���ٱ���
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param fileCapacity ������ �뷮
	 * @param fileType ������ ����
	 * @param comment ������ �ڸ�Ʈ ����
	 * @param lastModifyDate ������ ������ �������
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFile(Group accessAuth, String fileName, String filePath, float fileCapacity, String fileType, String comment, GregorianCalendar lastModifyDate, String uploaderId) {
		return files.add(new File(accessAuth, fileName, filePath, fileCapacity, fileType, comment, lastModifyDate, uploaderId));
	}
	/**
	 * ������ ��Ͽ� �߰��ϱ����� �޼ҵ� 
	 * @param fileCode ������ �ĺ��ڵ�
	 * @param folderCode ������ �����ڵ�
	 * @return �߰��� ���� ��������. ������ true, ���н� false ����
	 */
	public boolean addFile(String fileCode, String folderCode){
		return files.add(new File(fileCode, folderCode));
	}
	
	/**
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param folderCode ������ �����ڵ�
	 */
	public void deleteFolderCode(String folderCode){
		for(int i=0;i<this.files.size();i++){
			if(files.get(i).getFolderCode().equals(folderCode)){
				files.remove(i);
			}
		}
		
	}
	/**
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param fileCode ������ �ĺ��ڵ�
	 */
	public void deleteFileCode(String fileCode){
		files.remove(searchFileCode(fileCode));
	}
	
	/**
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param filePath ���ϰ��
	 * @param uploaderId ���δ����̵�
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
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param filePath ������ ���
	 * @param uploaderId ������ ���δ� ���̵�
	 */
	public void deleteFile(String filePath, String uploaderId) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				files.remove(i);
			}
		}
	}
	
	/**
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param uploaderId ������ ���δ� ���̵�
	 */
	public void deleteFile(String uploaderId) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getUploaderId().equals(uploaderId)){
				files.remove(i);
			}
		}
	}
	
	/**
	 * ������ ������κ��� �����ϱ����� �޼ҵ�
	 * @param file ���ϰ�ü
	 */
	public void deleteFile(File file) {
		files.remove(file);
	}
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param uploaderId ������ ���δ� ���̵�
	 * @param newFileName ������ �����̸�
	 */
	public void modifyFileName(String fileName, String filePath, String uploaderId, String newFileName) {
		searchFile(fileName, filePath, uploaderId).setFileName(newFileName);
	}
	
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param filePath ���ϰ��
	 * @param uploaderId ������ ���δ� ���̵�
	 * @param newFilePath ������ ������ ���
	 */
	public void modifyFilePath(String fileName, String filePath, String uploaderId, String newFilePath) {
		searchFile(fileName, filePath, uploaderId).setFilePath(newFilePath);
	}
	
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param filePath ���ϰ��
	 * @param uploaderId ������ ���δ� ���̵�
	 * @param newComment ������  ������ �ڸ�Ʈ ����
	 */
	public void modifyFileComment(String fileName, String filePath, String uploaderId, String newComment) {
		searchFile(fileName, filePath, uploaderId).setComment(newComment);
	}
	
	/**
	 * ������ ������ �����ϱ����� �޼ҵ�
	 * @param filePath ������ ���
	 * @param uploaderId ������ ���δ� ���̵�
	 * @param newFilePath ������ ������ ���
	 */
	public void modifyFilePathAll(String filePath, String uploaderId, String newFilePath) {
		for(int i=0;i<files.size();i++){
			if(files.get(i).getFilePath().equals(filePath) && files.get(i).getUploaderId().equals(uploaderId)){
				files.get(i).setFilePath(newFilePath);
			}
		}
	}
	
	/**
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param filePath ������ ���
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return File��ü
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
	 * ������ ��Ͽ��� �˻��ϱ� ���� �޼ҵ�
	 * @param filePath ������ ���
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return File�� ����Ʈ. �����Ͱ� �������� ���� ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ� ���� �޼ҵ�
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return File�� ����Ʈ. �����Ͱ� �������� ���� ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @return File�� ����Ʈ. �����Ͱ� ������������ ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileName ���ϸ�
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return File�� ����Ʈ. �����Ͱ� ������������ ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileType ������ ����
	 * @param uploaderId ������ ���δ� ���̵�
	 * @return File�� ����Ʈ. �����Ͱ� ������������ ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileType
	 * @return File�� ����Ʈ. �����Ͱ� ������������ ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param fileCode
	 * @return File��ü. ������������ ��� null ����
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
	 * ������ ��Ͽ��� �˻��ϱ����� �޼ҵ�
	 * @param folderCode
	 * @return File�� ����Ʈ. �����Ͱ� ������������ ��� null ����
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
	 * @return ������ ����Ʈ
	 */
	public ArrayList<File> getFiles() {
		return files;
	}
	/**
	 * setter
	 * @param files ������ ����Ʈ
	 */
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
}
