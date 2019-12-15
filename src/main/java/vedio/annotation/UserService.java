package vedio.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层
 */
@Service("userService")
public class UserService {
	
	
	UserRepository userRepository = null ; 
	
	
	
	public void add() {
		userRepository.save();
		System.out.println(this.getClass().getName()+"UserService add...业务层...");
	}


	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
