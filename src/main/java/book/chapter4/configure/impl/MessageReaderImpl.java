package book.chapter4.configure.impl;

import org.springframework.beans.factory.annotation.Autowired;

import book.chapter4.configure.MessageProvider;
import book.chapter4.configure.MessageReader;
import lombok.extern.slf4j.Slf4j;


public class MessageReaderImpl implements MessageReader{
	
	public MessageReaderImpl() {
		System.out.println("### @@@ ---> constructing reader ... ");
	}
	public MessageReaderImpl(MessageProvider provider) {
		System.out.println("### @@@ ---> constructing reader ... provider ... ");
	}
	
	@Autowired //不需要走 get/set ..
	private MessageProvider provider; 

	public void reader() {
		if(provider == null ) {
			throw new RuntimeException("provider 缺失 ") ;
		}
		System.out.println(getMessageProvider().getMessage());
	}

	public void setMessageProvider(MessageProvider provider) {
		System.out.println("### @@@ ---> setting the provider ... ");
		//this.provider = provider ; 
	}

	public MessageProvider getMessageProvider() {
		return provider ;
	}

}
