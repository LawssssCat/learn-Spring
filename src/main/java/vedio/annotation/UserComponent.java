package vedio.annotation;

import org.springframework.stereotype.Component;

@Component("userComponent")
public class UserComponent {
	@Override
	public String toString() {
		String s = super.toString();
		System.out.println(s);
		return s;
	}
}
