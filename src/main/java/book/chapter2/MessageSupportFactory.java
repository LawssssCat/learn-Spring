package book.chapter2;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式-优点：
 * 1.减少内存开支 
 * 2.优化和共享资源 
 * --------------
 * 工厂模式-优点：
 * 1.封装
 * 2.扩展
 * 3.解耦
 */
public class MessageSupportFactory {
	/* ---------------   饿汉-单例   ---------------------- */
	private static MessageSupportFactory instance ; 
	static {
		instance = new MessageSupportFactory();
	}
	//private MessageSupportFactory(){} //工厂实现
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	/* -------------    工厂     ----------------------------------- */
	MessageProvider provider ;
	MessageReader reader ;
	
	private MessageSupportFactory() {
		//书上props作为成员变量，为什么？
		Properties props = new Properties();
		try {
			props.load(
					getClass().
					getResourceAsStream(
							"/book/h_factory.properties"));
			/*
			 *           / - bin/
			 */
			
			String readerClass = props.getProperty("reader.class");
			String providerClass = props.getProperty("provider.class");
			
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
			reader = (MessageReader) Class.forName(readerClass).newInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MessageReader getMessagerReader() {
		return this.reader;
	}
	public MessageProvider getMessageProvider() {
		return this.provider;
	}
	
}
