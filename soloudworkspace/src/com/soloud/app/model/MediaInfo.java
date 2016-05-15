/**
 * 
 */
package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * 미디어파일정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class MediaInfo implements Serializable {

	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -3273835570418887301L;
	/**
	 * 파일 코드
	 */
	private String fileCode;
	/**
	 * 미디어파일코드
	 */
	private String mediaCode;
	/**
	 * 미디어 유형
	 * 비디오 또는 오디오
	 */
	private String mediaType;
	/**
	 * 재생시간
	 * hh : mm : ss
	 */
	private GregorianCalendar playTime;
	/**
	 * 재생 순번
	 */
	private int sequenceNumber;
	/**
	 * 미디어파일 경로
	 */
	private String mediaPath;
	/**
	 * 미디어파일 이름
	 */
	private String mediaFileName;
	/**
	 * 미디어파일 업로더 아이디
	 */
	private String uploaderId;
	/**
	 * MediaInfo클래스 오버로딩 생성자
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
	 * MediaInfo클래스 오버로딩 생성자
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
	 * MediaInfo클래스 오버로딩 생성자
	 * @param mediaType 미디어파일 유형
	 * @param playTime 재생시간
	 * @param sequenceNumber 재생 순번
	 * @param mediaPath 미디어파일 경로
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
	 * MediaInfo클래스 오버로딩 생성자
	 * @param mediaType 미디어 유형
	 * @param playTime 재생시간
	 * @param sequenceNumber 재생 순번
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime,
			int sequenceNumber) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * MediaInfo클래스 오버로딩 생성자
	 * @param mediaType 미디어파일 유형
	 * @param playTime 재생시간
	 */
	public MediaInfo(String mediaType, GregorianCalendar playTime) {
		super();
		this.mediaType = mediaType;
		this.playTime = playTime;
	}
	/**
	 * MediaInfo클래스 기본 생성자
	 */
	public MediaInfo() {
		
	}
	/**
	 * MediaInfo클래스 오버로딩 생성자
	 * @param fileCode 파일코드
	 * @param mediaCode 미디어파일코드
	 */
	public MediaInfo(String fileCode, String mediaCode){
		this.fileCode = fileCode;
		this.mediaCode = mediaCode;
	}
	/**
	 * MediaInfo클래스 오버로딩 생성자
	 * @param mediaCode
	 */
	public MediaInfo(String mediaCode){
		this.mediaCode = mediaCode;
	}
	/**
	 * getter
	 * @return 미디어파일 유형
	 */
	public String getMediaType() {
		return mediaType;
	}
	/**
	 * setter
	 * @param mediaType 미디어파일 유형 
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * getter
	 * @return 미디어파일 재생시간
	 */
	public GregorianCalendar getPlayTime() {
		return playTime;
	}
	/**
	 * setter
	 * @param playTime 미디어파일 재생시간
	 */
	public void setPlayTime(GregorianCalendar playTime) {
		this.playTime = playTime;
	}
	/**
	 * getter
	 * @return 미디어파일 재생 순번
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	/**
	 * setter
	 * @param sequenceNumber 미디어파일 재생 순번
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * getter
	 * @return 미디어파일 경로
	 */
	public String getMediaPath() {
		return mediaPath;
	}
	/**
	 * setter
	 * @param mediaPath 미디어파일 경로
	 */
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	/**
	 * getter
	 * @return 미디어파일이름
	 */
	public String getMediaFileName() {
		return mediaFileName;
	}
	/**
	 * setter
	 * @param mediaFileName 미디어파일이름
	 */
	public void setMediaFileName(String mediaFileName) {
		this.mediaFileName = mediaFileName;
	}
	/**
	 * getter
	 * @return 미디어파일 업로더 아이디
	 */
	public String getUploaderId() {
		return uploaderId;
	}
	/**
	 * setter
	 * @param uploaderId 미디어파일 업로더 아이디
	 */
	public void setUploaderId(String uploaderId) {
		this.uploaderId = uploaderId;
	}
	/**
	 * getter
	 * @return 파일코드
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * setter
	 * @param fileCode 파일코드
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * getter
	 * @return 미디어코드
	 */
	public String getMediaCode() {
		return mediaCode;
	}
	/**
	 * setter
	 * @param mediaCode 미디어코드
	 */
	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
	/**
	 * 미디어파일정보의 데이터를 문자열화하기위한 메소드
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
