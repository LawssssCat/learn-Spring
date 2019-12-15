package test.book.chapter3.orale;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import spring5.book.chapter3.beanfactory.Oracle;

public class Demo_DefaultListableBeanFactory {
	public static void main(String[] args) {
		//创建工厂
		DefaultListableBeanFactory factory = 
				new DefaultListableBeanFactory();
		//注册工厂
		//解读  xml to Bean 的 定义 的类 - "建厂咨询 - 帮你翻译需求文件"
		XmlBeanDefinitionReader xmlReader = 
				new XmlBeanDefinitionReader(factory);
		//传入 解读的 文件 - "资源"
		// 自动解读
		String resourcePath = 
				"resource/book/oracle_beanFactory.xml" ; 
		
		xmlReader.loadBeanDefinitions(
				new ClassPathResource(resourcePath));
		
		System.out.println("---------------------------");
		
		//工厂提供产品
		Oracle o = factory.getBean("wiseworm" , Oracle.class);
		String meaningOfLife = o.defineMeaningOfLife() ; 
		System.out.println(meaningOfLife);
	}
}
