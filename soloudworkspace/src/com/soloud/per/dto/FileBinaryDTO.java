package com.soloud.per.dto;
/**
 * 파일하나에 대한 바이너리정보를 캡슐화한 클래스
 * @author 장성봉
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
	 * 파일 바이너리의 공유한 코드
	 */
	private String fileBinaryCode;
	/**
	 * 파일코드
	 */
	private String fileCode;
	/**
	 * 파일바이너리 정보
	 */
	private Object fileBinary;
	/**
	 * 파일 크기
	 */
	private int size;
	/**
	 * 파일바이너리코드 getter메소드
	 * @return 파일바이너리코드
	 */
	public String getFileBinaryCode() {
		return fileBinaryCode;
	}
	/**
	 * 파일바이너리코드 setter메소드
	 * @param fileBinaryCode 변경 할 파일바이너리코드
	 */
	public void setFileBinaryCode(String fileBinaryCode) {
		this.fileBinaryCode = fileBinaryCode;
	}
	/**
	 * 파일코드 getter메소드
	 * @return 파일코드
	 */
	public String getFileCode() {
		return fileCode;
	}
	/**
	 * 파일코드 setter 메소드
	 * @param fileCode 변경 할 파일코드
	 */
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	/**
	 * 파일 바이너리 getter 메소드
	 * @return 파일 바이너리
	 */
	public Object getFileBinary() {
		return fileBinary;
	}
	/**
	 * 파일바이너리 setter 메소드
	 * @param fileBinary 변경 할 파일 바이너리
	 */
	public void setFileBinary(Object fileBinary) {
		this.fileBinary = fileBinary;
	}
	/**
	 * 오버오디드 생성자
	 * @param fileBinaryCode 파일바이너리코드
	 * @param fileCode 파일코드
	 * @param fileBinary 파일바이너리
	 * @param size 파일크기
	 */
	public FileBinaryDTO(String fileBinaryCode, String fileCode, Object fileBinary, int size) {
		super();
		this.fileBinaryCode = fileBinaryCode;
		this.fileCode = fileCode;
		this.fileBinary = fileBinary;
		this.size = size;
	}
	/**
	 * Default 생성자
	 */
	public FileBinaryDTO() {
		super();
	}
	/**
	 * 파일크기 getter 메소드
	 * @return 파일크기
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 파일크기 setter 메소드
	 * @param size 파일크기
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
