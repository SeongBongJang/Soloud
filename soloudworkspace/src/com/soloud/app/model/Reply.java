package com.soloud.app.model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * ��������� ĸ��ȭ�� Ŭ����
 * @author oong
 *
 */
public class Reply implements Serializable {

	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = -7486952576799220480L;
	/**
	 * �ۼ��� ���̵�
	 */
	private String writerId;
	/**
	 * �ۼ� ����
	 */
	private String content;
	/**
	 * �ۼ�����
	 */
	private GregorianCalendar writeDate;
	/**
	 * Reply �����ε� ������
	 * @param writerId �ۼ��� ���̵�
	 * @param content �ۼ� ����
	 * @param writeDate �ۼ�����
	 */
	public Reply(String writerId, String content, GregorianCalendar writeDate) {
		this.writerId = writerId;
		this.content = content;
		this.writeDate = writeDate;
	}
	/**
	 * Reply �����ε� ������
	 * @param writerId �ۼ��� ���̵�
	 * @param content �ۼ� ����
	 */
	public Reply(String writerId, String content) {
		super();
		this.writerId = writerId;
		this.content = content;
	}
	/**
	 * Reply �����ε� ������
	 * @param writerId �ۼ��� ���̵�
	 */
	public Reply(String writerId) {
		super();
		this.writerId = writerId;
	}
	/**
	 * Reply �⺻ ������
	 */
	public Reply() {
		super();
	}
	/**
	 * getter
	 * @return �ۼ��� ���̵�
	 */
	public String getWriterId() {
		return writerId;
	}
	/**
	 * setter
	 * @param writerId �ۼ��� ���̵�
	 */
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	/**
	 * getter
	 * @return �ۼ�����
	 */
	public String getContent() {
		return content;
	}
	/**
	 * setter
	 * @param content �ۼ� ����
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * getter
	 * @return �ۼ�����
	 */
	public GregorianCalendar getWriteDate() {
		return writeDate;
	}
	/**
	 * setter
	 * @param writeDate �ۼ�����
	 */
	public void setWriteDate(GregorianCalendar writeDate) {
		this.writeDate = writeDate;
	}
	/**
	 * Reply��ü�� �����͸� ���ڿ�ȭ�ϱ����� �޼ҵ�
	 */
	@Override
	public String toString() {
		return "Reply [writerId=" + writerId + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
}
