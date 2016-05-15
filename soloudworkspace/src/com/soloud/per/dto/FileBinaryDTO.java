package com.soloud.per.dto;
/**
 * �����ϳ��� ���� ���̳ʸ������� ĸ��ȭ�� Ŭ����
 * @author �强��
 *
 */
public class FileBinaryDTO 
{
	@Override
	public String toString() {
		return "FileBinaryDTO [fileBinaryCode=" + fileBinaryCode
				+ ", fileCode=" + fileCode + ", fileBinary=" + fileBinary + "]";
	}
	/**
	 * ���� ���̳ʸ��� ������ �ڵ�
	 */
	private String fileBinaryCode;
	/**
	 * �����ڵ�
	 */
	private String fileCode;
	/**
	 * ���Ϲ��̳ʸ� ����
	 */
	private Object fileBinary;
	/**
	 * ���� ũ��
	 */
	private int size;
	/**
	 * ���Ϲ��̳ʸ��ڵ� getter�޼ҵ�
	 * @return ���Ϲ��̳ʸ��ڵ�
	 */
	public String getFileBinaryCode() {
		return fileBinaryCode;
	}
	/**
	 * ���Ϲ��̳ʸ��ڵ� setter�޼ҵ�
	 * @param fileBinaryCode ���� �� ���Ϲ��̳ʸ��ڵ�
	 */
	public void setFileBinaryCode(String fileBinaryCode) {
		this.fileBinaryCode = fileBinaryCode;
	}
	/**
	 * �����ڵ� getter�޼ҵ�
	 * @return �����ڵ�
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * �����ڵ� setter �޼ҵ�
	 * @param fileCode ���� �� �����ڵ�
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * ���� ���̳ʸ� getter �޼ҵ�
	 * @return ���� ���̳ʸ�
	 */
	public Object getFileBinary() {
		return fileBinary;
	}
	/**
	 * ���Ϲ��̳ʸ� setter �޼ҵ�
	 * @param fileBinary ���� �� ���� ���̳ʸ�
	 */
	public void setFileBinary(Object fileBinary) {
		this.fileBinary = fileBinary;
	}
	/**
	 * ��������� ������
	 * @param fileBinaryCode ���Ϲ��̳ʸ��ڵ�
	 * @param fileCode �����ڵ�
	 * @param fileBinary ���Ϲ��̳ʸ�
	 * @param size ����ũ��
	 */
	public FileBinaryDTO(String fileBinaryCode, String fileCode, Object fileBinary, int size) {
		super();
		this.fileBinaryCode = fileBinaryCode;
		this.fileCode = fileCode;
		this.fileBinary = fileBinary;
		this.size = size;
	}
	/**
	 * Default ������
	 */
	public FileBinaryDTO() {
		super();
	}
	/**
	 * ����ũ�� getter �޼ҵ�
	 * @return ����ũ��
	 */
	public int getSize() {
		return size;
	}
	/**
	 * ����ũ�� setter �޼ҵ�
	 * @param size ����ũ��
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
