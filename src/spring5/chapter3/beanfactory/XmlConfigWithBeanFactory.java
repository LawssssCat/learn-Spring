package spring5.chapter3.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {
	public static void main(String[] args) {
		//创建工厂
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//注册工厂
		//解读  xml to Bean 的 定义 的类 - "建厂咨询 - 帮你翻译需求文件"
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(factory);
		//传入 解读的 文件 - "资源"
		// 自动解读
		String resourcePath = "spring5/chapter3/beanfactory/xml-bean-factory-config.xml" ; 
		xmlReader.loadBeanDefinitions(new ClassPathResource(resourcePath)) ;
		
		//工厂提供产品
		Oracle o = factory.getBean("wiseworm" , Oracle.class);
		String meaningOfLife = o.defineMeaningOfLife() ; 
		System.out.println(meaningOfLife);
	}
}
