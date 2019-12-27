package book.chapter3;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_Hierarchical_ApplicationContext {
	private GenericXmlApplicationContext parent = null ; 
	private GenericXmlApplicationContext child = null ; 
	
	{
		parent = new GenericXmlApplicationContext();
		parent.load("classpath:book/h_application-parent.xml");
		parent.refresh();
		
		child = new GenericXmlApplicationContext();
		child.load("classpath:book/h_application-child.xml");
		child.setParent(parent);
		child.refresh();
	}
	@Test
	public void test_Hierarchical() {
		Song s1 = child.getBean("song1" , Song.class); 
		Song s2 = child.getBean("song2" , Song.class); 
		Song s3 = child.getBean("song3" , Song.class);
		
		
		
		System.out.println("song1:childTile ==> " + s1.getTitle());
		System.out.println("song2:parentTile ==> " + s2.getTitle());
		System.out.println("song3:childTile - parent ==> " + s3.getTitle());
		
	}
}
