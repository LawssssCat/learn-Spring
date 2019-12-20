package book.chapter3.lookupmethodinjection.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import book.chapter3.lookupmethodinjection.DemoBean;
import book.chapter3.lookupmethodinjection.Singer;

@Component("standardLookupBean")
public class StandardLookkupDemoBean_annotation implements DemoBean {
	
	@Autowired
	@Qualifier("singer")
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
