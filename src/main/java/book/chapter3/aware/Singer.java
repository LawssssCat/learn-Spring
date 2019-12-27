package book.chapter3.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer implements  ApplicationContextAware {
	
	private ApplicationContext apx ;
	private Guitar guitar ; 

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		apx = applicationContext ; 
	}
	
	
	public void sing() {
		Guitar guitar = apx.getBean("g" , Guitar.class);
		guitar.sing(); 
	}
	

}
