package book.chapter4.messagesource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		MessageEvent messageEvent = (MessageEvent) event ;
		String msg = messageEvent.getMsg();
		System.out.println("@@@@ ------ : "+ msg);
	}

}
