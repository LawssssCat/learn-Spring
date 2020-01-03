package book.chapter4;

import java.security.MessageDigest;

import org.springframework.beans.factory.DisposableBean;

public class MessageDigester implements DisposableBean {
	
	private MessageDigest messageDigest1 ; 
	private MessageDigest messageDigest2 ;
	
	public void setMessageDigest1(MessageDigest messageDigest) {
		this.messageDigest1 = messageDigest;
	}
	public void setMessageDigest2(MessageDigest messageDigest) {
		this.messageDigest2 = messageDigest;
	} 
	
	public void messageDigest(String msg) {
		System.out.println("Using digest1");
		messageDigest(msg, messageDigest1) ;
		
		System.out.println("Using digest2");
		messageDigest(msg, messageDigest2);
	}
	private void messageDigest(String msg, MessageDigest messageDigest) {
		System.out.println("Using alogrithm: "+messageDigest.getAlgorithm());
		messageDigest.reset(); 
		byte[] bytes = msg.getBytes();
		byte[] out = messageDigest.digest(bytes);
		System.out.println(out);
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("### @@@ ------- MessageDigester destory ... ");
	}
	
	
}
