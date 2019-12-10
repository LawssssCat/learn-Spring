package spring5.chapter2.helloworld.helloworld2;

import java.util.Arrays;

public class Demo_helloworld2 {
	public static void main(String[] args) {
		if(args.length>0) {
			System.out.println(Arrays.toString(args));
		}else {
			System.out.println("Hello Wrold");
		}
	}
}
