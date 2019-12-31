package book.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
	
	public ShutdownHookBean() {
		System.out.println("### ShutdownHookBean constructor ... ");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(applicationContext instanceof GenericXmlApplicationContext) {
			GenericXmlApplicationContext gtx = (GenericXmlApplicationContext)applicationContext ;
			gtx.registerShutdownHook(); 
			System.out.println("#### registerShutdownHook() ... ");
		}
		
	}

}
