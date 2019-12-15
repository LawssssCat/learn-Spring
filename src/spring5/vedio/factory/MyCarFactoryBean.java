package spring5.vedio.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;

public class MyCarFactoryBean implements FactoryBean<Car> {
	
	String brankSS ;
	
	public void setBrankCC(String brankAA) {
		this.brankSS = "福特";
		this.brankSS = brankAA;
	}

	@Override
	public Car getObject() throws Exception {
		return new Car(brankSS, 3000);  
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	/**
	 * 是否单例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	

}
