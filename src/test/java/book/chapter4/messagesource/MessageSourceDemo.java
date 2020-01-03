package book.chapter4.messagesource;

import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/messagesource/app-config-messagesource.xml");
		gcx.refresh();
		Locale english = Locale.ENGLISH ; 
		Locale german = new Locale("de", "DE") ; 
		
		System.out.println(english);
		System.out.println(german);
		
		System.out.println("$$$  ###++ --- ======== ");
		System.out.println(gcx.getMessage("msg", null, english));
		System.out.println(gcx.getMessage("msg", null, german));
		
		System.out.println("$$$  ###++ --- ======== ");
		Object[] objs  = new Object[] {"John" ,"Mayer" } ; 
		
		System.out.println(gcx.getMessage("nameMsg", objs , english  )); ; 
		System.out.println(gcx.getMessage("nameMsg", objs , german ) );; 
		
		//gcx.close();
	}
}
