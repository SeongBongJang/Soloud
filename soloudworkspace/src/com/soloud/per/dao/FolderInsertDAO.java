//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FolderInsertDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import com.soloud.per.dto.FolderDTO;
/**
 * ���� �����͸� �߰��ϴ� �������̽�
 * @author �强�� <hr>
 * ���� �����ͺ��̽��� ������ ������ ������ �����͸� <br>
 * �߰��ϴ� �������̽�<br>
 * �� �������̽��� �޼ҵ尡 ȣ��Ǹ� Ʈ���Ű� �߻�<br>
 * Ʈ������ ���ǿ� ����<br>
 * �������������� ���� �����ͺ��̽��� ���� �����ڵ带 ���� �����͸� �߰�<br>
 */
public interface FolderInsertDAO
{
	/**
	 * ���� �����ͺ��̽��� ������ ����ڵ�,�θ����ڵ�,�����̸�,������������,����url �����͸�<br>
	 * ������ Record�� �߰��ϴ� �޼ҵ�<br>
	 * �� �޼ҵ尡 ȣ��Ǹ� Ʈ���Ű� �߻�<br>
	 * Ʈ������ ���ǿ� ����<br>
	 * �������������� ���� �����ͺ��̽��� ���� �����ڵ带 ���� �����͸� �߰�<br>
	 * @param memberCode ����ڵ�
	 * @param parentFolderCode �θ����ڵ�
	 * @param folderName �����̸�
	 * @param isSharedFolder ������������
	 * @param folderUrl ���� url
	 * @return ���������� �߰��� ��� -true
	 */
	public boolean insertFolder(String memberCode, String parentFolderCode, String folderName, String isSharedFolder, String folderUrl);
	/**
	 * ���� �����ͺ��̽��� ������ �����͸� <br>
	 * ĸ��ȭ�ϴ� FolderDTO�� �߰��ϴ� �޼ҵ�<br>
	 * �� �޼ҵ尡 ȣ��Ǹ� Ʈ���Ű� �߻�<br>
	 * Ʈ������ ���ǿ� ����<br>
	 * �������������� ���� �����ͺ��̽��� ���� �����ڵ带 ���� �����͸� �߰�<br>
	 * @param dto ����ڵ�,�θ����ڵ�,�����̸�,������������,����url�� ĸ��ȭ�� FolderDTO ��ü
	 * @return ���������� �߰��� ��� -true
	 */
	public boolean insertFolderDTO(FolderDTO dto);
}