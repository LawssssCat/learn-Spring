package spring5.book.chapter2;

public class StandardOutMessageReader implements MessageReader {
	private MessageProvider provider ; 
	
	@Override
	public void reader() {
		if(provider==null) {
			throw new RuntimeException(
			"You must set the property messageProvider of class:"
			+provider.getClass().getName());
		}
		System.out.println(provider.getMassage());
	}
	
	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.provider=provider ; 
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.provider;
	}

}
