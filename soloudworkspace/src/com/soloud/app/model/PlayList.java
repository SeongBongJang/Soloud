package com.soloud.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;





/**
 * 재생목록을 관리하기위한 클래스
 * @author oong
 *
 */
public class PlayList implements Serializable{
	/**
	 * 시리얼 버전 아이디
	 */
	private static final long serialVersionUID = 8516864624290619292L;
	/**
	 * 각 회원별 재생목록
	 */
	private Hashtable<String, ArrayList<MediaInfo>> mediaInfoes;
	/**
	 * PlayList 오버로딩 생성자
	 * @param mediaInfo MediaInfo객체, 미디어정보es 각 회원별 재생목록
	 */
	public PlayList(Hashtable<String, ArrayList<MediaInfo>> mediaInfoes) {
		this.mediaInfoes = mediaInfoes;
	}
	/**
	 * PlayList 기본 생성자
	 */
	public PlayList() {
		this(new Hashtable<String, ArrayList<MediaInfo>>());
	}

	/**
	 * 재생목록을 추가하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaCode 미디어코드
	 * @param fileCode 파일코드
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addMediaInfo(String id, String mediaCode, String fileCode){
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(mediaCode, fileCode));
	}
	/**
	 * 재생목록을 추가하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaCode 미디어코드
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addMediaInfo(String id, String mediaCode){
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(id, mediaCode));
	}
	/**
	 * 재생목록을 추가하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaInfo MediaInfo객체, 미디어정보
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addMediaInfo(String id, MediaInfo mediaInfo) {
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(mediaInfo);
	}
	
	/**
	 * 재생목록을 추가하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaType 미디어 유형 미디어 유형
	 * @param playTime
	 * @param sequenceNumber
	 * @param mediaPath
	 * @param mediaFileName
	 * @param uploaderId
	 * @return 추가에 대한 성공여부 성공시 true, 실패시 false 리턴
	 */
	public boolean addMediaInfo(String id, String mediaType, GregorianCalendar playTime, int sequenceNumber, String mediaPath, String mediaFileName, String uploaderId) {
		if(mediaInfoes.get(id) == null){
			mediaInfoes.put(id, new ArrayList<MediaInfo>());
		}
		return mediaInfoes.get(id).add(new MediaInfo(mediaType, playTime, sequenceNumber, mediaPath, mediaFileName, uploaderId));
	}
	
	/**
	 * 재생목록을 삭제하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
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
	 * 재생목록을 삭제하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaInfo MediaInfo객체, 미디어정보
	 */
	public void deleteMediaInfo(String id, MediaInfo mediaInfo) {
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			mediaInfoes.remove(mediaInfo);			
		}
	}
	/**
	 * 재생목록을 삭제하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaCode 미디어코드
	 */
	public void deleteMediaInfoCode(String id, String mediaCode){
		if(mediaInfoes.get(id) == null){
			return;
		} else {
			mediaInfoes.get(id).remove(searchMediaInfoCode(id, mediaCode));			
		}
	}
	/**
	 * 재생목록을 삭제하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param fileCode 파일코드
	 */
	public void deleteMediaInfoFile(String id, String fileCode){
		
	}
	/**
	 * 재생목록을 수정하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
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
	 * 재생목록을 수정하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaInfo MediaInfo객체, 미디어정보
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
	 * 재생목록을 수정하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
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
	 * 재생목록을 수정하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaCode 미디어코드
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
	 * 재생목록을 검색하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디 사용자 아이디
	 * @return 미디어정보목록. 검색결과 없을 시 null 리턴
	 */
	public ArrayList<MediaInfo> searchMediaInfo(String id) {
		if(mediaInfoes.get(id) == null){
			return null;
		} else {
			return mediaInfoes.get(id);
		}
	}
	
	/**
	 * 재생목록을 검색하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaFileName
	 * @param mediaPath
	 * @param uploaderId
	 * @return 미디어정보. 검색결과 없을 시 null 리턴
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
	 * 재생목록을 검색하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaType 미디어 유형 미디어 유형
	 * @param sequenceNumber
	 * @return 미디어정보. 검색결과 없을 시 null 리턴
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
	 * 재생목록을 검색하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaType 미디어 유형 미디어 유형
	 * @return 미디어정보목록. 검색결과 없을 시 null 리턴
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
	 * 재생목록을 검색하기위한 메소드
	 * @param id 사용자 아이디 사용자 아이디
	 * @param mediaCode 미디어코드
	 * @return 미디어정보. 검색결과 없을 시 null 리턴
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
	 * @return 각 회원별 재생목록
	 */
	public Hashtable<String, ArrayList<MediaInfo>> getMediaInfoes() {
		return mediaInfoes;
	}
	
	/**
	 * setter
	 * @param mediaInfoes 각 회원별 재생목록
	 */
	public void setMediaInfoes(Hashtable<String, ArrayList<MediaInfo>> mediaInfoes) {
		this.mediaInfoes = mediaInfoes;
	}
}
