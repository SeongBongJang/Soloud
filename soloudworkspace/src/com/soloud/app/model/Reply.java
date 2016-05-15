package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 댓글정보를 캡슐화한 클래스
 * @author oong
 *
 */
public class Reply implements Serializable {

	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = -7486952576799220480L;
	/**
	 * 작성자 아이디
	 */
	private String writerId;
	/**
	 * 작성 내용
	 */
	private String content;
	/**
	 * 작성일자
	 */
	private GregorianCalendar writeDate;
	/**
	 * Reply 오버로딩 생성자
	 * @param writerId 작성자 아이디
	 * @param content 작성 내용
	 * @param writeDate 작성일자
	 */
	public Reply(String writerId, String content, GregorianCalendar writeDate) {
		this.writerId = writerId;
		this.content = content;
		this.writeDate = writeDate;
	}
	/**
	 * Reply 오버로딩 생성자
	 * @param writerId 작성자 아이디
	 * @param content 작성 내용
	 */
	public Reply(String writerId, String content) {
		super();
		this.writerId = writerId;
		this.content = content;
	}
	/**
	 * Reply 오버로딩 생성자
	 * @param writerId 작성자 아이디
	 */
	public Reply(String writerId) {
		super();
		this.writerId = writerId;
	}
	/**
	 * Reply 기본 생성자
	 */
	public Reply() {
		super();
	}
	/**
	 * getter
	 * @return 작성자 아이디
	 */
	public String getWriterId() {
		return writerId;
	}
	/**
	 * setter
	 * @param writerId 작성자 아이디
	 */
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	/**
	 * getter
	 * @return 작성내용
	 */
	public String getContent() {
		return content;
	}
	/**
	 * setter
	 * @param content 작성 내용
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * getter
	 * @return 작성일자
	 */
	public GregorianCalendar getWriteDate() {
		return writeDate;
	}
	/**
	 * setter
	 * @param writeDate 작성일자
	 */
	public void setWriteDate(GregorianCalendar writeDate) {
		this.writeDate = writeDate;
	}
	/**
	 * Reply객체의 데이터를 문자열화하기위한 메소드
	 */
	@Override
	public String toString() {
		return "Reply [writerId=" + writerId + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
}
