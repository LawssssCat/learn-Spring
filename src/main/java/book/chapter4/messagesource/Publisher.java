package book.chapter4.messagesource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Publisher implements ApplicationContextAware{
	
	private ApplicationContext acx ; 

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		acx = applicationContext ; 
	}
	
	public void publish(String msg) {
		acx.publishEvent(new MessageEvent(acx, msg));
	}

}
