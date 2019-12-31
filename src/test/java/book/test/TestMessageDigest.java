package book.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class TestMessageDigest {

	@Test
	public void testMessageDigest() throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5"); 
		String algorithm = md5.getAlgorithm();
		System.out.println(md5);
		System.out.println(algorithm);
		System.out.println("-----------------------");
		
		
		
	}
	
}
