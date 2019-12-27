package book.chapter3.lookupmethodinjection.imp;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import book.chapter3.lookupmethodinjection.DemoBean;
import book.chapter3.lookupmethodinjection.Singer;

@Component("abstractLookupBean")
public abstract class AbstractLookupDemoBean_annotation implements DemoBean {

	@Override
	@Lookup("singer")
	public abstract Singer getMySinger() ;  

	@Override
	public void doSomething() {
		getMySinger().sing();
	}

}
