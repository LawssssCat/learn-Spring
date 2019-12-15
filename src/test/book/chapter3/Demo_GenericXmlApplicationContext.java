package test.book.chapter3;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring5.book.chapter3.MessageReader;



public class Demo_GenericXmlApplicationContext {
	public static void main(String[] args) {
		System.out.println("-----------  GenericXmlApplicationContext  ---------------");
		
		
		GenericXmlApplicationContext gxac = 
				new GenericXmlApplicationContext();
		/*
		 * Component("provider") - 注解 - 组件
		 * Service("reader") - 注解 - 服务
		 * AutoWired - 自动装配
		 */
		System.out.println("-----------  Context - scanpackage ---------------");
		gxac.load(
				"classpath:resource/book/h_applicationContext-scanpackage.xml");
		
		System.out.println("---");
		//没有refresh，会抛出IllegalStateException
		//GenericXmlApplicationContext@7eda2dbb has not been refreshed yet
		gxac.refresh();
		
		System.out.println("---");
		
		MessageReader mr = (MessageReader) gxac.getBean("reader99");
		
		System.out.println("----");
		
		mr.reader();
		
		gxac.close();
		
		
		
		
		System.out.println("--------------- XML 标签注入  ---------------------");
		
		/*
		 * 同为ApplicationContext
		 * GenericXmlApplicationContext 同样可以读取 XML 标签手动装配的 配置
		 * 
		 */
		GenericXmlApplicationContext gxac2 = new GenericXmlApplicationContext();
		//xml注入
		gxac2.load("resource/book/h_applicationContext.xml");
		gxac2.refresh();
		spring5.book.chapter2.MessageReader mr2 = gxac2.getBean("reader" , spring5.book.chapter2.MessageReader.class);
		mr2.reader();
		
		gxac2.close();
	}
}
