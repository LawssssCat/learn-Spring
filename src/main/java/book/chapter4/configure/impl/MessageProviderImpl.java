package book.chapter4.configure.impl;

import book.chapter4.configure.MessageProvider;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class MessageProviderImpl implements MessageProvider {
	private String message = "Default message" ; 
	public MessageProviderImpl() {}
}
