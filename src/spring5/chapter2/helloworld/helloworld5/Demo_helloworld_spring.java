package spring5.chapter2.helloworld.helloworld5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring5.chapter2.helloworld.helloworld3.MessageReader;

public class Demo_helloworld_spring {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring5/chapter2/helloworld/helloworld5/applicationContext.xml");
		MessageReader mr = ctx.getBean("reader",MessageReader.class);
		mr.reader();
	}
}
