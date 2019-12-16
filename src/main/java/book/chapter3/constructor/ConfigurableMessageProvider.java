package book.chapter3.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import book.chapter3.MessageProvider;

@Service("provider123")
public class ConfigurableMessageProvider implements MessageProvider {
	private String message ;
	
	@Autowired
	public ConfigurableMessageProvider(String message ) {
		this.message = message ; 
	}

	@Override
	public String getMassage() {
		System.out.println("aa");
		return message;
	}

}
