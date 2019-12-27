package book.chapter3.lookupmethodinjection.imp;

import book.chapter3.lookupmethodinjection.DemoBean;
import book.chapter3.lookupmethodinjection.Singer;

public class StandardLookkupDemoBean implements DemoBean {
	
	private Singer mySinger ; 

	@Override
	public Singer getMySinger() {
		return this.mySinger;
	}

	@Override
	public void doSomething() {
		mySinger.sing();
	}

	public void setMySinger(Singer mySinger) {
		this.mySinger = mySinger;
	}

}
