package spring5.book.chapter3;

public interface MessageReader {
	void reader();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
