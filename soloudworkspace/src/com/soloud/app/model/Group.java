package com.soloud.app.model;
/**
 * �׷������� ������ Ŭ����
 * @author oong
 *
 */
public enum Group {
	BESTFRIEND("��ģ"), NORMALFRIEND("ģ��"), AWKWARDFRIEND("�����ģ��");
	/**
	 * �׷�����
	 */
	final private String groupKind;
	
	/**
	 * �׷����� �⺻������
	 * @param groupKind
	 */
	private Group(String groupKind){
		this.groupKind = groupKind; 
	}
	/**
	 * �׷������� ���� ������� �޼ҵ�
	 * @return
	 */
	public String value(){
		return this.groupKind;
	}
}
