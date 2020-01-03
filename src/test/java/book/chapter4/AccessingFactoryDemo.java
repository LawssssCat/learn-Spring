package book.chapter4;

import java.security.MessageDigest;
import java.util.Arrays;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AccessingFactoryDemo {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/app-context-messagedigest.xml");
		gcx.refresh(); 
		
		String[] names = gcx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("=++++++++++++=+++++++++++++=");

		MessageDigest shaDigest = gcx.getBean("shaDigest", MessageDigest.class);
		
		MessageDigestFactoryBean factorybean = gcx.getBean("&shaDigest" , MessageDigestFactoryBean.class);
		try {
			MessageDigest object = factorybean.getObject();
			System.out.println("is same ? "+(shaDigest==object));
			byte[] str = object.digest("Hello World!".getBytes());
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gcx.close();
		
		System.out.println("finish ...");		
	}
}
