//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SharedFolderDeleteDAO.java
//  @ Date : 2014-07-19
//  @ Author : 
//
//
package com.soloud.per.dao;
import java.util.GregorianCalendar;
/**
 * 공유폴더 데이터 삭제 인터페이스
 * @author 장성봉<hr>
 * 공유폴더 데이터베이스에서 지정한 데이터를 가지는 Record를 삭제하는 인터페이스<br>
 * 이 인터페이스이 메소드가 호출 되면 트리거가 발생<br>
 * 공유폴더의 공유친구정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제<br>
 * 댓글정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제
 */
public interface SharedFolderDeleteDAO
{
	/**
	 * 공유폴더 데이터베이스에서 지정한 공유폴더 코드 데이터를 가지는 Record를 삭제하는 메소드<br>
	 * 메소드가 호출 되면 트리거가 발생<br>
	 * 공유폴더의 공유친구정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제<br>
	 * 댓글정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제
	 * @param sharedFolderCode 공유폴더코드
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteSharedFolderCode(String sharedFolderCode);
	/**
	 * 공유폴더 데이터베이스에서 지정한 폴더코드 데이터를 가지는 Record를 삭제하는 메소드<br>
	 * 메소드가 호출 되면 트리거가 발생<br>
	 * 공유폴더의 공유친구정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제<br>
	 * 댓글정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제
	 * @param folderCode 폴더코드
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteFolderCode(String folderCode);
	/**
	 * 공유폴더 데이터베이스에서 지정한 공유폴더의 생성 기간 데이터를 가지는 Record를 삭제하는 메소드<br>
	 * 메소드가 호출 되면 트리거가 발생<br>
	 * 공유폴더의 공유친구정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제<br>
	 * 댓글정보를 가진 데이터베이스에서 같은 공유폴더코드를 가진 데이터를 모두 삭제
	 * @param startDate 삭제할 공유폴더의 생성일 시작일
	 * @param endDate 삭제항 공유폴더의 생성일 마지막일
	 * @return 성공적으로 삭제한 행의 개수
	 */
	public int deleteSharedFolderMakeDate(GregorianCalendar startDate, GregorianCalendar endDate);
}
