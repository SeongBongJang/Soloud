package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;





/**
 * �������� �����ϱ����� Ŭ����
 * @author oong
 *
 */
public class PlayList implements Serializable{
	/**
	 * �ø��� ���� ���̵�
	 */
	private static final long serialVersionUID = 8516864624290619292L;
	/**
	 * �� ȸ���� ������
	 */
	private Hashtable<String, ArrayList<MediaInfo>> mediaInfoes;
	/**
	 * PlayList �����ε� ������
	 * @param mediaInfo MediaInfo��ü, �̵������es �� ȸ���� ������
	 */
	public PlayList(Hashtable<String, ArrayList<MediaInfo>> mediaInfoes) {
		this.mediaInfoes = mediaInfoes;
	}
	/**
	 * PlayList �⺻ ������
	 */
	public PlayList() {
		this(new Hashtable<String, ArrayList<MediaInfo>>());
	}

	/**
	 * �������� �߰��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaCode �̵���ڵ�
	 * @param fileCode �����ڵ�
	 * @return �߰��� ���� �������� ������ true, ���н� false ����
	 */
	public boolean addMediaInfo(String id, String mediaCode, String fileCode){
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(mediaCode, fileCode));
	}
	/**
	 * �������� �߰��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaCode �̵���ڵ�
	 * @return �߰��� ���� �������� ������ true, ���н� false ����
	 */
	public boolean addMediaInfo(String id, String mediaCode){
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(id, mediaCode));
	}
	/**
	 * �������� �߰��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaInfo MediaInfo��ü, �̵������
	 * @return �߰��� ���� �������� ������ true, ���н� false ����
	 */
	public boolean addMediaInfo(String id, MediaInfo mediaInfo) {
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(mediaInfo);
	}
	
	/**
	 * �������� �߰��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaType �̵�� ���� �̵�� ����
	 * @param playTime
	 * @param sequenceNumber
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 * @return �߰��� ���� �������� ������ true, ���н� false ����
	 */
	public boolean addMediaInfo(String id, String mediaType, GregorianCalendar playTime, int sequenceNumber, String mediaPath, String mediaFileName, String uploaderId) {
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(mediaType, playTime, sequenceNumber, mediaPath, mediaFileName, uploaderId));
	}
	
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 */
	public void deleteMediaInfo(String id, String mediaPath, String mediaFileName, String uploaderId) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getUploaderId().equals(uploaderId) && mediaList.get(i).getMediaFileName().equals(mediaFileName) &&  mediaList.get(i).getMediaPath().equals(mediaPath)){
					
				}
			}
			
		}
	}
	
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaInfo MediaInfo��ü, �̵������
	 */
	public void deleteMediaInfo(String id, MediaInfo mediaInfo) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			mediaInfoes.remove(mediaInfo);			
		}
	}
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaCode �̵���ڵ�
	 */
	public void deleteMediaInfoCode(String id, String mediaCode){
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			mediaInfoes.get(id).remove(searchMediaInfoCode(id, mediaCode));			
		}
	}
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param fileCode �����ڵ�
	 */
	public void deleteMediaInfoFile(String id, String fileCode){
		
	}
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 * @param newMediaInfo
	 */
	public void modifyMediaInfo(String id, String mediaPath, String mediaFileName, String uploaderId, MediaInfo newMediaInfo) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getUploaderId().equals(uploaderId) && mediaList.get(i).getMediaPath().equals(mediaPath) && mediaList.get(i).getMediaFileName().equals(mediaFileName)){
					mediaList.set(i, newMediaInfo);
					return;
				}
			}
		}
	}
	
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaInfo MediaInfo��ü, �̵������
	 * @param newMediaInfo
	 */
	public void modifyMediaInfo(String id, MediaInfo mediaInfo, MediaInfo newMediaInfo) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			mediaList.set(mediaList.indexOf(mediaInfo), newMediaInfo);
		}
	}
	
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 * @param sequenceNumber
	 */
	public void modifyMediaInfoSequenceNumber(String id, String mediaPath, String mediaFileName, String uploaderId, int sequenceNumber) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getUploaderId().equals(uploaderId) && mediaList.get(i).getMediaPath().equals(mediaPath) && mediaList.get(i).getMediaFileName().equals(mediaFileName)){
					mediaList.get(i).setSequenceNumber(sequenceNumber);
					return;
				}
			}
		}
	}
	/**
	 * �������� �����ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaCode �̵���ڵ�
	 * @param newSequenceNumber
	 */
	public void modifyMediaInfoCode(String id, String mediaCode, int newSequenceNumber){
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getMediaCode().equals(mediaCode)){
					mediaList.get(i).setSequenceNumber(newSequenceNumber);
					return;
				}
			}
		}
	}
	
	/**
	 * �������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵� ����� ���̵�
	 * @return �̵���������. �˻���� ���� �� null ����
	 */
	public ArrayList<MediaInfo> searchMediaInfo(String id) {
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			return mediaInfoes.get(id);
		}
	}
	
	/**
	 * �������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaFileName
	 * @param mediaPath
	 * @param uploaderId
	 * @return �̵������. �˻���� ���� �� null ����
	 */
	public MediaInfo searchMediaInfo(String id, String mediaFileName, String mediaPath, String uploaderId) {
		
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getMediaFileName().equals(mediaFileName) && mediaList.get(i).getMediaPath().equals(mediaPath) && mediaList.get(i).getUploaderId().equals(uploaderId)){
					return mediaList.get(i);
				}
			}
			return null;
		}
	}
	
	/**
	 * �������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaType �̵�� ���� �̵�� ����
	 * @param sequenceNumber
	 * @return �̵������. �˻���� ���� �� null ����
	 */
	public MediaInfo searchMediaInfo(String id, String mediaType, int sequenceNumber) {
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getMediaType().equals(mediaType) && mediaList.get(i).getSequenceNumber() == sequenceNumber){
					return mediaList.get(i);
				}
			}
			return null;	
		}
	}
	
	/**
	 * �������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaType �̵�� ���� �̵�� ����
	 * @return �̵���������. �˻���� ���� �� null ����
	 */
	public ArrayList<MediaInfo> searchMediaInfo(String id, String mediaType) {
		ArrayList<MediaInfo> returnList = new ArrayList<MediaInfo>();
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getMediaType().equals(mediaType)){
					returnList.add(mediaList.get(i));
				}
			}
			if(returnList.isEmpty()){
				return null;
			}
			return returnList;
		}
	}
	/**
	 * �������� �˻��ϱ����� �޼ҵ�
	 * @param id ����� ���̵� ����� ���̵�
	 * @param mediaCode �̵���ڵ�
	 * @return �̵������. �˻���� ���� �� null ����
	 */
	public MediaInfo searchMediaInfoCode(String id, String mediaCode){
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			ArrayList<MediaInfo> mediaList = mediaInfoes.get(id);
			for(int i=0;i<mediaList.size();i++){
				if(mediaList.get(i).getMediaCode().equals(mediaCode)){
					return mediaList.get(i);
				}
			}
			return null;
		}
	}
	/**
	 * getter
	 * @return �� ȸ���� ������
	 */
	public Hashtable<String, ArrayList<MediaInfo>> getMediaInfoes() {
		return mediaInfoes;
	}
	
	/**
	 * setter
	 * @param mediaInfoes �� ȸ���� ������
	 */
	public void setMediaInfoes(Hashtable<String, ArrayList<MediaInfo>> mediaInfoes) {
		this.mediaInfoes = mediaInfoes;
	}
}
