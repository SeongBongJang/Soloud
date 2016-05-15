package com.soloud.per.dto;
/**
 * �������ϱ׷������� ĸ��ȭ�ϰ� �ִ� Ŭ����
 * @author �强��
 *
 */
public class AvailableFileAuthGroupDTO 
{
	@Override
	public String toString() {
		return "AvailableFileAuthGroupDTO [fileCode=" + fileCode
				+ ", groupCode=" + groupCode + "]";
	}
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * �׷��ڵ�
	 */
	private String groupCode;
	/**
	 * �����ڵ� getter�޼ҵ�
	 * @return �����ڵ�
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * Defalut ������
	 */
	public AvailableFileAuthGroupDTO() {
		super();
	}
	/**
	 * �����ε�� ������
	 * @param fileCode �����ڵ�
	 * @param groupCode �׷��ڵ�
	 */
	public AvailableFileAuthGroupDTO(String fileCode, String groupCode) {
		super();
		this.fileCode = fileCode;
		this.groupCode = groupCode;
	}
	/**
	 * �����ڵ� setter�޼ҵ�
	 * @param fileCode �����ڵ�
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * �׷��ڵ� getter �޼ҵ�
	 * @return �׷��ڵ�
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * �׷��ڵ� setter �޼ҵ�
	 * @param groupCode �׷��ڵ�
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
	
}
