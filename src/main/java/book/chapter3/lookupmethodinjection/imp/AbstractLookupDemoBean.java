package book.chapter3.lookupmethodinjection.imp;

import book.chapter3.lookupmethodinjection.DemoBean;
import book.chapter3.lookupmethodinjection.Singer;

public abstract class AbstractLookupDemoBean implements DemoBean {

	@Override
	public abstract Singer getMySinger() ;  

	@Override
	public void doSomething() {
		getMySinger().sing();
	}

}
