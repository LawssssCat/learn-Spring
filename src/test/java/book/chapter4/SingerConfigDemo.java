package book.chapter4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerConfigDemo {

	@Configuration
	static class SingerConfig {
		
		@Lazy
		@Bean(initMethod = "init")
		Singer singerOne() {
			Singer  singer = new Singer() ; 
			singer.setName("one");
			singer.setAge(1);
			return singer ; 
		}
		@Lazy
		@Bean(initMethod = "init")
		Singer singerTwo() {
			Singer  singer = new Singer() ; 
			singer.setAge(2);
			return singer ; 
		}
		@Lazy
		@Bean(initMethod = "init")
		Singer singerThree() {
			Singer  singer = new Singer() ; 
			singer.setName("three");
			return singer ; 
		}
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = 
				new AnnotationConfigApplicationContext(SingerConfig.class);
		
		Singer.getBean( "singerOne" , atx) ; 
		Singer.getBean( "singerTwo" , atx) ; 
		Singer.getBean( "singerThree" , atx) ; 
		
		atx.close();
	}
	
}
