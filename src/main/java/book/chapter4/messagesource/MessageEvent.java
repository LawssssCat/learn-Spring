package book.chapter4.messagesource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MessageEvent extends ApplicationContextEvent {
	
	private String msg ; 
	
	public MessageEvent(ApplicationContext source , String msg) {
		super(source);
		this.msg = msg ; 
	}
	
	public String getMsg() {
		return msg;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
