package com.soloud.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class ASEEnctypt 
{
	 public String testASEEncodeWithKey(String folderCode, String password) throws Exception 
	 {
		 // password = "1234";		//비밀번호(키)
		 // url = "원문";		//원래 url
		  
		 byte[] seedB = password.getBytes();
		  SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		  sr.setSeed(seedB);  
		  KeyGenerator kgen = KeyGenerator.getInstance("AES");
		  kgen.init(128, sr); // 192 and 256 bits may not be available  
		  // Generate the secret key specs.
		  SecretKey skey = kgen.generateKey();
		  String keyString = Hex.encodeHexString(skey.getEncoded());
		  SecretKeySpec skeySpec = new SecretKeySpec(skey.getEncoded(), "AES");   
		  Cipher cipher = Cipher.getInstance("AES");
		  cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		     byte[] encrypted =  cipher.doFinal(folderCode.getBytes());
		      
		   String  encString =  Hex.encodeHexString(encrypted);
		      
		  System.out.println("encrypted string: [" + keyString + "] " + encString );
		  return encString;
	 }
	  
	 public String testASEDecodeWithKey(String encryptedCode, String password) throws Exception 
	 {
		  //password = "1234";
		 byte[] seedB = password.getBytes();
		  SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		  sr.setSeed(seedB);
		   
		  KeyGenerator kgen = KeyGenerator.getInstance("AES");
		  kgen.init(128, sr); // 192 and 256 bits may not be available
		   
		  // Generate the secret key specs.
		  SecretKey skey = kgen.generateKey();
		  String keyString = Hex.encodeHexString(skey.getEncoded());
		  SecretKeySpec skeySpec = new SecretKeySpec(skey.getEncoded(), "AES"); 
		   
		  Cipher cipher = Cipher.getInstance("AES");
		  cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		     byte[] decrypted =  cipher.doFinal(Hex.decodeHex(encryptedCode.toCharArray()));
		      
		     System.out.println("decrypted string: [" + keyString + "] " + new String(decrypted));
		  System.out.println("decrypted string: " + new String(decrypted));
		  return new String(decrypted);
	 }
	
	 public static void main(String[] a) throws Exception
	 {
		 ASEEnctypt t = new ASEEnctypt();
		String enc = t.testASEEncodeWithKey("폴더코드38", "1234");
		String dec = t.testASEDecodeWithKey(enc, "1234");
		
		System.out.println(dec);
	}
		
	 
	 
}