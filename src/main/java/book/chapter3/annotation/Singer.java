package book.chapter3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singer")
public class Singer {
	
	@Autowired
	private Inspiration inspiraionBean ;
	
	public void sing() {
		System.out.println("... "+ inspiraionBean.getLyric());
	}
}
