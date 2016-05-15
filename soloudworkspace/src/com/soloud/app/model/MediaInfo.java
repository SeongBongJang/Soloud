/**
 * 
 */
package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * �̵������������ ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class MediaInfo implements Serializable {

	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -3273835570418887301L;
	/**
	 * ���� �ڵ�
	 */
	private String fileCode;
	/**
	 * �̵�������ڵ�
	 */
	private String mediaCode;
	/**
	 * �̵�� ����
	 * ���� �Ǵ� �����
	 */
	private String mediaType;
	/**
	 * ����ð�
	 * hh : mm : ss
	 */
	private GregorianCalendar playTime;
	/**
	 * ��� ����
	 */
	private int sequenceNumber;
	/**
	 * �̵������ ���
	 */
	private String mediaPath;
	/**
	 * �̵������ �̸�
	 */
	private String mediaFileName;
	/**
	 * �̵������ ���δ� ���̵�
	 */
	private String uploaderId;
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaType
	 * @param playTime
	 * @param sequenceNumber
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime,
			int sequenceNumber, String mediaPath, String mediaFileName,
			String uploaderId) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
		this.sequenceNumber = sequenceNumber;
		this.mediaPath = mediaPath;
		this.mediaFileName = mediaFileName;
		this.uploaderId = uploaderId;
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaType
	 * @param playTime
	 * @param sequenceNumber
	 * @param mediaPath
	 * @param mediaFileName
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime,
			int sequenceNumber, String mediaPath, String mediaFileName) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
		this.sequenceNumber = sequenceNumber;
		this.mediaPath = mediaPath;
		this.mediaFileName = mediaFileName;
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaType �̵������ ����
	 * @param playTime ����ð�
	 * @param sequenceNumber ��� ����
	 * @param mediaPath �̵������ ���
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime,
			int sequenceNumber, String mediaPath) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
		this.sequenceNumber = sequenceNumber;
		this.mediaPath = mediaPath;
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaType �̵�� ����
	 * @param playTime ����ð�
	 * @param sequenceNumber ��� ����
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime,
			int sequenceNumber) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaType �̵������ ����
	 * @param playTime ����ð�
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
	}
	/**
	 * MediaInfoŬ���� �⺻ ������
	 */
	public MediaInfo() {
		
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param fileCode �����ڵ�
	 * @param mediaCode �̵�������ڵ�
	 */
	public MediaInfo(String fileCode, String mediaCode){
		this.fileCode = fileCode;
		this.mediaCode = mediaCode;
	}
	/**
	 * MediaInfoŬ���� �����ε� ������
	 * @param mediaCode
	 */
	public MediaInfo(String mediaCode){
		this.mediaCode = mediaCode;
	}
	/**
	 * getter
	 * @return �̵������ ����
	 */
	public String getMediaType() {
		return mediaType;
	}
	/**
	 * setter
	 * @param mediaType �̵������ ���� 
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * getter
	 * @return �̵������ ����ð�
	 */
	public GregorianCalendar getPlayTime() {
		return playTime;
	}
	/**
	 * setter
	 * @param playTime �̵������ ����ð�
	 */
	public void setPlayTime(GregorianCalendar playTime) {
		this.playTime = playTime;
	}
	/**
	 * getter
	 * @return �̵������ ��� ����
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	/**
	 * setter
	 * @param sequenceNumber �̵������ ��� ����
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * getter
	 * @return �̵������ ���
	 */
	public String getMediaPath() {
		return mediaPath;
	}
	/**
	 * setter
	 * @param mediaPath �̵������ ���
	 */
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	/**
	 * getter
	 * @return �̵�������̸�
	 */
	public String getMediaFileName() {
		return mediaFileName;
	}
	/**
	 * setter
	 * @param mediaFileName �̵�������̸�
	 */
	public void setMediaFileName(String mediaFileName) {
		this.mediaFileName = mediaFileName;
	}
	/**
	 * getter
	 * @return �̵������ ���δ� ���̵�
	 */
	public String getUploaderId() {
		return uploaderId;
	}
	/**
	 * setter
	 * @param uploaderId �̵������ ���δ� ���̵�
	 */
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}
	/**
	 * getter
	 * @return �����ڵ�
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * setter
	 * @param fileCode �����ڵ�
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * getter
	 * @return �̵���ڵ�
	 */
	public String getMediaCode() {
		return mediaCode;
	}
	/**
	 * setter
	 * @param mediaCode �̵���ڵ�
	 */
	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
	/**
	 * �̵������������ �����͸� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "MediaInfo [fileCode=" + fileCode + ", mediaCode=" + mediaCode
				+ ", mediaType=" + mediaType + ", playTime=" + playTime
				+ ", sequenceNumber=" + sequenceNumber + ", mediaPath="
				+ mediaPath + ", mediaFileName=" + mediaFileName
				+ ", uploaderId=" + uploaderId + "]";
	}
	
}
