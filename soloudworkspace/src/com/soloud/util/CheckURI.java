package com.soloud.util;
public class CheckURI {
	/**
	 * URL �޺κ� ����
	 * @param url
	 * @return
	 */
	static public String getLastURI(StringBuffer url){
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		return action;
	}
}
