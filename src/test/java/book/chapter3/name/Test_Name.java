package book.chapter3.name;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_Name {
	private static  GenericXmlApplicationContext gtx = null ; 
	static {
		gtx = new GenericXmlApplicationContext() ; 
		gtx.load("classpath:book/name/name_getBeansOfType.xml");
		gtx.refresh();
	}
	
	@Test
	public void testName() {
		Map<String, String> map = gtx.getBeansOfType(String.class);
		map.entrySet().forEach(e -> System.out.println(
				e.getKey() + ":" + e.getValue()));
		gtx.close();
	}
}
