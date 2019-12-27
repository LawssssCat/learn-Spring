package book.chapter3.methodlookup;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import book.chapter3.lookupmethodinjection.DemoBean;
import book.chapter3.lookupmethodinjection.Singer;

public class Test_MethodLookup_annotation {
	private static GenericXmlApplicationContext gtx = null ;
	static { 
		gtx = new GenericXmlApplicationContext() ; 
		gtx.load("classpath:book/methodlookup/h_aplicationContext-methodInjection-annotation.xml");
		gtx.refresh();
	}
	
	@Test
	public void testMethodLookup() {
		DemoBean abstractBean = gtx.getBean("abstractLookupBean" , DemoBean.class); 
		DemoBean standardBean = gtx.getBean("standardLookupBean" , DemoBean.class); 
		
		displayInfo("standardBean" , standardBean) ; 
		displayInfo("abstractBean" , abstractBean) ; 
	}

	private void displayInfo(String beanName, DemoBean bean) {
		Singer s1 = bean.getMySinger() ; 
		Singer s2 = bean.getMySinger() ;
		System.out.println(beanName+": Singer Instances the Same? "+(s1==s2));
		
		StopWatch watch = new StopWatch();
		int times =  1000000 ;
		watch.start();
		Singer s  = null  ; 
		for(int i=0 ; i<times; i++ ) { 
			s = bean.getMySinger() ; 
			s.sing();
			//System.out.println(s.getLyric());
		}
		
		watch.stop();  
		System.out.println(times + " gets took "+ watch.getTotalTimeMillis() + "ms");
		
		
	}
}
