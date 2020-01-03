package book.chapter4.messagesource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationEventDemo {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath:book/chapter4/messagesource/app-config-applicationevent.xml");
		Publisher p = ctx.getBean("publisher" , Publisher.class); 
		p.publish("I send an SOS to the world .. ");
		p.publish("... I hope that someone gets my ... ");
		p.publish("... Message in a bootle");
		
	}
}
