package book.chapter4.configure;

public interface MessageReader {

	void reader() ;
	void setMessageProvider(MessageProvider provider) ; 
	MessageProvider getMessageProvider() ;
	
}
