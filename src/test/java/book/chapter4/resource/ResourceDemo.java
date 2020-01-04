package book.chapter4.resource;

import java.io.File;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceDemo {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext acx = new ClassPathXmlApplicationContext();
		
		File file = File.createTempFile("test", "txt") ; 
		System.out.println(file.getPath());
		System.out.println("################################");
		
		Resource res1 = acx.getResource("file://"+file.getPath());
		try {
			displayInfo(res1);
		}catch (Exception e) {
			System.out.println(e.getMessage()+"\n");
		}
		file.deleteOnExit();
		
		System.out.println("################################");
		
		Resource res2 = acx.getResource("classpath:test.txt");
		displayInfo(res2);
		
		System.out.println("################################");
		Resource res3 = acx.getResource("http://www.baidu.com");
		displayInfo(res3);
		
	}
	
	private static void displayInfo(Resource res) throws IOException {
		System.out.println(res.getClass());
		System.out.println(res.getURL());
		System.out.println(res.getURL().getContent());
		System.out.println();
	}
	
}
