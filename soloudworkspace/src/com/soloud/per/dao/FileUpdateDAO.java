//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FileUpdateDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;//
import java.util.GregorianCalendar;
/**
 * ���� �����͸� �����ϴ� �������̽�
 * @author �强�� <hr>
 * ���� �����ͺ��̽����� ������ �����͸� ������ <br>
 * Record�� ������ �����ͷ� �����ϴ� �������̽�
 */
public interface FileUpdateDAO
{
	/**
	 * ���ϵ����ͺ��̽����� ������ �����ڵ� �����͸� ������ <br>
	 * Record�� ������ �������� ������ �����ͷ� �����ϴ� �޼ҵ�
	 * @param fileCode �����ڵ�
	 * @param latestModifyDate ������ ������
	 * @return ���������� ������ ���� ����
	 */
	public int updateFileCodeLatestModifyDate(String fileCode, GregorianCalendar latestModifyDate);
	/**
	 * ���ϵ����ͺ��̽����� ������ �����ڵ� �����͸� ������ <br>
	 * Record�� �����ڸ�Ʈ �����͸� ������ �����ͷ� �����ϴ� �޼ҵ�
	 * @param fileCode �����ڵ�
	 * @param fileComment �����ڸ�Ʈ
	 * @return ���������� ������ ���� ����
	 */
	public int updateFileCodeFileComment(String fileCode, String fileComment);
	/**
	 * ���ϵ����ͺ��̽����� ������ �����ڵ� �����͸� ������ <br>
	 * Record�� �����̸��� ������ �����ͷ� �����ϴ� �޼ҵ�
	 * @param fileCode �����ڵ�
	 * @param fileName �����̸�
	 * @return ���������� ������ ���� ����
	 */
	public int updateFileCodeFileName(String fileCode, String fileName);
	/**
	 * ���ϵ����ͺ��̽����� ������ �����ڵ� �����͸� ������ <br>
	 * Record�� �������Ͽ��θ� ������ �����ͷ� �����ϴ� �޼ҵ�
	 * @param fileCode �����ڵ�
	 * @param fileIsShared �������� ����
	 * �������Ͽ��� : "����" �ƴѰ�� : "�Ϲ�"
	 * @return ���������� ������ ���� ����
	 */
	public int updateFileCodeFileIsShared(String fileCode, String fileIsShared);
	/**
	 * ���ϵ����ͺ��̽����� ������ �����ڵ� �����͸� ������ <br>
	 * Record�� �����ڵ带 ������ �����ڵ� �����ͷ� �����ϴ� �޼ҵ�
	 * @param fileCode �����ڵ�
	 * @param newFolderCode ���� �� ���� �ڵ�
	 * @return ���������� ������ ���� ����
	 */
	public int updateFileCodeFolderCode(String fileCode,String newFolderCode);
}