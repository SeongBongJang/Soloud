package com.soloud.per.dao;

import java.util.List;

import com.soloud.per.dto.MemberFileAuthVDTO;

/**
 * Ư��ȸ���� ���� ���� ������ ������ �˻��� �� �ִ� �������̽�
 * @author BK
 *
 */
public interface MemberFileAuthVDAO 
{
	//���δ����̵�, ���δ��̸�, ���ϸ�, 
	//����������
	/**
	 * ��� ȸ���� ���� ������ ���� ����Ʈ�� �����´�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchAllMemberFileAuth();
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ȸ���� ���� ���� ������ ��� ������ ������ �����´�
	 * @param memberCode ����ڵ�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuth(String memberCode);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� ���δ� �ڵ忡 �ش��ϴ� ȸ���� ���ε��� ������ ������ �����´�. 
	 * @param memberCode ����ڵ�
	 * @param uploaderCode ���δ� �ڵ�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(String memberCode, String uploaderCode);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� ���δ� �̸��� �ش��ϴ� ȸ���� ���ε��� ������ ������ �����´�. 
	 * @param memberCode ����ڵ�
	 * @param uploaderName ���δ��̸�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(String memberCode, String uploaderName);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� �˻��Ϸ��� ���ϸ��� ���� ������ ������ �����´�. 
	 * @param memberCode ����ڵ�
	 * @param fileName �����̸�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileName(String memberCode, String fileName);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� Ư�� Ÿ���� ���Ͽ� ���� ������ �����´�
	 * @param memberCode ����ڵ�
	 * @param fileType ����ڵ�
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileType(String memberCode, String fileType);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� Ư�� ���δ� �ڵ�� ����Ÿ�Կ� �ش��ϴ� ������ ������ �����´�
	 * @param memberCode ����ڵ�
	 * @param uploaderCode ���δ��ڵ�
	 * @param fileType ����Ÿ��
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderCode(String memberCode, String uploaderCode, String fileType);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� Ư�� ���δ� �̸��� ����Ÿ�Կ� �ش��ϴ� ������ ������ �����´�.
	 * @param memberCode ����ڵ�
	 * @param uploaderName ���δ� �̸�
	 * @param fileType ����Ÿ�� 
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeUploaderName(String memberCode, String uploaderName, String fileType);
	/**
	 * ����ڵ忡 �ش��ϴ� ȸ���� ���� ������ ���� �� Ư�� ���δ� �Ϲǰ� ����Ÿ�Կ� �ش��ϴ� ������ ������ �����´�.
	 * @param memberCode ����ڵ�
	 * @param fileName �����̸�
	 * @param fileType ���� Ÿ��
	 * @return ���ٰ����� ��� ������ ����Ʈ
	 */
	public List<MemberFileAuthVDTO> searchMemberFileAuthMemberCodeFileNameFileType(String memberCode, String fileName, String fileType);
	
	
}
