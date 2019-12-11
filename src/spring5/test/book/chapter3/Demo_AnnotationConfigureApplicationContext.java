package spring5.test.book.chapter3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5.chapter3.HelloWorldConfiguration_ComponentScan;
import spring5.chapter3.MessageReader;
import spring5.chapter3.old.HelloWorldConfigure;

public class Demo_AnnotationConfigureApplicationContext {
	public static void main(String[] args) {
		System.out.println("------------ AnnotationConfigApplicationContext   -------------------");
		
		
		System.out.println("------------  Configure Bean  -------------------");
		/*
		 * AnnotationConfigApplicationContext
		 * 同样的，如 chapter2一样，
		 * 可以通过 @Configure @Bean
		 * 创建 需要手动组装的类
		 */
		AnnotationConfigApplicationContext ac0 = new AnnotationConfigApplicationContext(HelloWorldConfigure.class);
		MessageReader ms0 = ac0.getBean("reader" , MessageReader.class );
		ms0.reader();
		
		
		System.out.println("-------------  Configure ComponentScan  -----------------------");
		/*
		 * AnnotationConfigApplicationContext
		 * 可以 通过 传入，@CommponentScan的Configure，
		 * 告知要扫描的包 和 子包（如这里的old）
		 * 
		 * 包内有标签 @Component、@Service、
		 * 从而得到类
		 */
		ApplicationContext ac = 
				new AnnotationConfigApplicationContext(
						HelloWorldConfiguration_ComponentScan.class) ;
		System.out.println("---");
		MessageReader reader = 
				ac.getBean("reader99" , MessageReader.class);
		reader.reader();
		
	}
}
