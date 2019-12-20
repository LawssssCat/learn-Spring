package book.chapter3.lookupmethodinjection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("singer")
public class Singer_annotation extends Singer {
	
}
