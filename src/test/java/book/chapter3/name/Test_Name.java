package book.chapter3.name;

import java.util.Arrays;
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
	}
	
	@Test
	public void testAliasName() {
		String[] aliases = gtx.getAliases("string1");
		System.out.println(Arrays.toString(aliases));
	}
	
	@Test
	public void testNameCrashID() {
		Map<String, A> beans = gtx.getBeansOfType(A.class);
		beans.entrySet().forEach(e -> System.out.println(
			"id="+e.getKey()+"\n"+
			"aliases="+ Arrays.toString(gtx.getAliases(e.getKey()))+ "\n" +
			"-------------"
			));
		
//		Double d = null ; 
//		double dd = d ;
//		System.out.println(dd);
		
	}
}
