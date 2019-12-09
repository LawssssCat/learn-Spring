package spring5.chapter2.helloworld.helloworld3;

public interface MessageReader {
	void reader();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
