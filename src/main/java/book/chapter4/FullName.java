package book.chapter4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@Data
public class FullName {

	private String firstName ; 
	private String lastName ; 
	
}
