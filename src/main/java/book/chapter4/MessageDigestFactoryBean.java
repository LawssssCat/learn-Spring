package book.chapter4;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean 
implements FactoryBean<MessageDigest> , InitializingBean {

	private String algorithmName = "MD5" ; 
	private MessageDigest messageDigest ;
	
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
	@Override
	public MessageDigest getObject() throws Exception {
		return messageDigest;
	}

	//这里为null，没关系，获取实例时候，可以指定。
	@Override
	public Class<?> getObjectType() {
		return MessageDigest.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true ; 
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		messageDigest = MessageDigest.getInstance(algorithmName) ; 
	}

}
