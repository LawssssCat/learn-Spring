package book.chapter2;

public interface MessageReader {
	void reader();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
