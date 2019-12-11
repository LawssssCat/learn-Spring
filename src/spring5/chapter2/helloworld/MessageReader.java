package spring5.chapter2.helloworld;

public interface MessageReader {
	void reader();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
