package book.chapter4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactory2 {
	private String algorithmName = "MD5" ; 
	
	public MessageDigest createInstance() throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(this.algorithmName) ; 
	}
	
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName ; 
	}
}
