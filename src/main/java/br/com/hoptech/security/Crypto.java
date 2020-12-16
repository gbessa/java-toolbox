package br.com.hoptech.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    
    public static void main(String[] args) {
	
	String password = "HelloWorld";
	try {
	    System.out.println(md5(password));
	    System.out.println(sha256(password));
	    
	} catch (Exception e) {
	    // TODO: handle exception
	}
	
    }
    
    public static String md5(String password) throws Exception {
	
	// Ja foi quebrado e nao deve mais ser usado
	
	MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes(), 0, password.length());
        
        return new BigInteger(1, m.digest()).toString(16);
	
    }
    
    public static String sha256(String password) throws NoSuchAlgorithmException {
	//Mais segura !
	//https://www.baeldung.com/sha-256-hashing-java
	
	MessageDigest digest = MessageDigest.getInstance("SHA-256");
	byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	
	return bytesToHex(encodedhash);
    }
    
    private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
    }

}
