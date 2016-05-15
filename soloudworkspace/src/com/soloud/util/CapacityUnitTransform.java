package com.soloud.util;

public class CapacityUnitTransform {
	public static String transform(float dataSize){
		return String.format("%.3f", dataSize/1048576)+" MByte";
	}
	public static float reverseTransform(String dataSize){
		char unit = dataSize.charAt(dataSize.indexOf(" ")+1);
		String byteData = null;
		byteData = dataSize.substring(0, dataSize.indexOf(" "));
		if(unit == 'K'){
			return Float.parseFloat(byteData)*1024f;
		} else if(unit == 'M'){
			return Float.parseFloat(byteData)*1024f*1024f;
		} else{
			return Float.parseFloat(byteData);
		}
	}
}	
