package com.soloud.app.manInt;

import java.util.ArrayList;

import com.soloud.app.model.File;
import com.soloud.app.model.FileList;

public interface FileSearchable {
	/**
	 * ��� ��������, ��� ��ϱⰣ�� �ش��ϴ� ��� ���� �˻� (������)
	 * @return
	 */
	public ArrayList<File> searchAllFile();
	/**
	 * �ش� ���� ����, ��� ��ϱⰣ�� �ش��ϴ� ���ϸ� �˻� (������)
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchAllFileTypeName(String fileType, String fileName);
	/**
	 * �ش� ��ϱⰣ, ��� ���� ������ �ش��ϴ� ���ϸ� �˻� (������)
	 * @param fileName
	 * @param filePath
	 * @return
	 */
	public ArrayList<File> searchAllFileDateName(int underDate, String fileName);
	/**
	 * �ش� ���� ����, �ش� ��ϱⰣ�� �ش��ϴ� ���ϸ� �˻� (������)
	 * @param fileType
	 * @param underDate
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchAllFile(String fileType, int underDate, String fileName);
	/**
	 * ȸ�� ���� ���ֿ��� ȸ���� ��� ������ �˻�
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchFile(String id);
	/**
	 * ȸ�� ���� ���ֿ��� ���� ������ ���� �˻�
	 * @param id
	 * @param filePath
	 * @return
	 */
	public ArrayList<File> searchFileType(String id, String fileType);
	/**
	 * ȸ�� ���� ���ֿ��� ���� �̸��� ���� ��� ������ ���� �˻�
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchMyFileName(String id, String fileName);
	/**
	 * ȸ�� ���� ���ֿ��� ���δ� �̸��� ���ԵǴ� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchMyFileUploaderName(String id, String uploaderName);
	/**
	 * ȸ�� ���� ���ֿ��� ���δ� �̸��� ���Եǰ� ���� Ÿ���� ��ġ�ϴ� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileUploaderType(String id, String uploaderName, String fileType);
	/**
	 * ȸ�� ���� ���ֿ��� ���� Ÿ���� ��ġ�ϴ� ���� �˻�
	 * @param id
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileType(String id, String fileType);
	/**
	 * ȸ�� ���� ���ֿ��� ���� ������ ���� �̸��� ���� ���� �˻�
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchMyFileNameType(String id, String fileName, String fileType);
	/**
	 * �ش� ���� �ڵ忡 ���� �˻�
	 * @param id
	 * @param fileCode
	 * @return
	 */
	public File searchFileCode(String id, String fileCode);
	/**
	 * ��� ���� ���ֿ��� ���ϸ�� ���������� ���� �˻�
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileNameType(String id, String fileName, String fileType);
	/**
	 * ��� ���� ���ֿ��� ���δ� �̸��� ���������� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileUploaderNameType(String id, String uploaderName, String fileType);
	/**
	 * ��� ���� ���ֿ��� ���ε� �̸��� ��� ���������� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchFileUploaderName(String id, String uploaderName);
	/**
	 * ��� ���� ���ֿ��� ���δ� ���̵�� ���������� ���� �˻�
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchFileUploaderIdType(String id, String uploaderId, String fileType);
	/**
	 * ��� ���� ���ֿ��� ���δ� ���̵�� ��� ���������� ���� �˻�
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchFileUploaderId(String id, String uploaderId);
	/**
	 * ��� ���� ���ֿ��� ���� �̸��� ���� ��� ������ ���� �˻�
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchFileName(String id, String fileName);
	/**
	 * �ش� ���� �ڵ带 ���� ��� ������ �˻�
	 * @param id
	 * @param folderCode
	 * @return
	 */
	public ArrayList<File> searchFolderCode(String id, String folderCode);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ��� ������ �˻���
	 * @param id
	 * @return
	 */
	public ArrayList<File> searchSharedFile(String id);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴ� ��� ������ �ش� Ÿ���� ���� �˻�
	 * @param id
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileType(String id, String fileType);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� �̸��� ���� ���� �˻�
	 * @param id
	 * @param fileName
	 * @return
	 */
	public ArrayList<File> searchSharedFileName(String id, String fileName);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� �ش� �̸��� ����
	 * �ش� ���� Ÿ���� ���� �˻�
	 * @param id
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedFileNameType(String id, String fileName, String fileType);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ� 
	 * ���� �̸��� ���� ���δ��� ������ ��� ģ���� ���� �˻� 
	 * @param id
	 * @param uploaderName
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderName(String id, String uploaderName);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� ���� ���δ��� �ƴϰ�
	 * ���� �̸��� ���� ���δ��� �����ϸ� �ش� ���� Ÿ���� ���� �˻�
	 * @param id
	 * @param uploaderName
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderNameType(String id, String uploaderName, String fileType);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� �� ���̵� �ƴ� �ٸ� ���δ��� ���� �˻�
	 * @param id
	 * @param uploaderId
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderId(String id, String uploaderId);
	/**
	 * ���� ȣ��Ʈ�̰ų� �ʴ�� ���������� ��� ���ϵ� �� �� ���̵� �ƴ� �ٸ� ���δ��� �����߿���
	 * �ش� ���� Ÿ���� ���� ��
	 * @param id
	 * @param uploaderId
	 * @param fileType
	 * @return
	 */
	public ArrayList<File> searchSharedUploaderIdType(String id, String uploaderId, String fileType);
}
