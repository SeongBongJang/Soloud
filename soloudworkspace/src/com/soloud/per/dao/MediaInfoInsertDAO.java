
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MediaInfoInsertDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import com.soloud.per.dto.MediaInfoDTO;
/**
 * �̵������ �����͸� �߰��ϴ� �������̽�
 * @author �强��
 * �̵������ �����ͺ��̽��� ������ �����͸� ������<br> 
 * Record�� �߰��ϴ� �������̽�
 */
public interface MediaInfoInsertDAO
{
	/**
	 * �̵������ �����ͺ��̽��� ������ ����ڵ�,�����ڵ�,�̵���������ȣ �����͸� <br>
	 * Record�� �߰��ϴ� �޼ҵ�
	 * @param memberCode ����ڵ�
	 * @param fileCode �����ڵ�
	 * @param mediaSequence �̵�� ������ ��ȣ
	 * @return ���������� �߰��� ��� - true
	 */
	public boolean insert(String memberCode, String fileCode, int mediaSequence);
	/**
	 * �̵������ �����ͺ��̽��� ������ �����͸� ĸ��ȭ�� <br>
	 * MediaInfoDTO ��ü�� Record�� �߰��ϴ� �޼ҵ�
	 * @param dto  ����ڵ�,�����ڵ�,�̵���������ȣ �� ĸ��ȭ�� MediaInfoD	TO��ü
	 * @return ���������� �߰��� ��� - true
	 */
	public boolean insertMediaInfoDTO(MediaInfoDTO dto);
}