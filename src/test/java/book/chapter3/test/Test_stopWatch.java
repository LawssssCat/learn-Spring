package book.chapter3.test;

import org.junit.Test;
import org.springframework.util.StopWatch;

public class Test_stopWatch {
	public static void main(String[] args) {
		testStopWatch();
	}
	public static  void testStopWatch() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("Test_stopWatch");  
		for(int i=0 ; i<1000 ; i++) {
			System.out.println(i);
		}
		stopWatch.stop();
		System.out.println("done. use "+ stopWatch.getTotalTimeMillis()+"ms");
		
	}
}
