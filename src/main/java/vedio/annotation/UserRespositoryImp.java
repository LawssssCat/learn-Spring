package vedio.annotation;

import org.springframework.stereotype.Repository;

/**
 * 持久层
 */
@Repository("userRepository1")
public class UserRespositoryImp implements UserRepository{

	@Override
	public void save() {
		System.out.println("UserRepository save...持久层...");
	}

}
