package com.soloud.per.dto;
/**
 * �������� ���ٰ��� ģ�������� ĸ��ȭ�ϰ� �ִ� Ŭ����
 * @author �强��
 *
 */
public class AvailableFolderFriendDTO 
{
	@Override
	public String toString() {
		return "AvailableFolderFriendDTO [friendCode=" + friendCode
				+ ", sharedFolderCode=" + sharedFolderCode + "]";
	}
	/**
	 * ģ���� ����ڵ�
	 */
	private String friendCode;
	/**
	 * �������� �ڵ�
	 */
	private String sharedFolderCode;
	/**
	 * �����ε�� ������
	 * @param friendCode ģ���ڵ�
	 * @param sharedFolderCode ���������ڵ�
	 */
	public AvailableFolderFriendDTO(String friendCode, String sharedFolderCode) {
		super();
		this.friendCode = friendCode;
		this.sharedFolderCode = sharedFolderCode;
	}
	/**
	 * ����Ʈ ������
	 */
	public AvailableFolderFriendDTO() {
		super();
	}
	/**
	 * ģ�� ����ڵ� getter �޼ҵ�
	 * @return ģ�� ����ڵ�
	 */
	public String getFriendCode() {
		return friendCode;
	}
	/**
	 * ģ������ڵ� setter �޼ҵ�
	 * @param friendCode ģ������ڵ�
	 */
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	/**
	 * �������� �ڵ� getter �޼ҵ�
	 * @return �������� �ڵ�
	 */
	public String getSharedFolderCode() {
		return sharedFolderCode; 
	}
	/**
	 * �������� �ڵ� setter �޼ҵ�
	 * @param sharedFolderCode �������� �ڵ�
	 */
	public void setSharedFolderCode(String sharedFolderCode) {
		this.sharedFolderCode = sharedFolderCode;
	}
}
