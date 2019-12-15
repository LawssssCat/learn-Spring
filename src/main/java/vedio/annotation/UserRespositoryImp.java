package vedio.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 */
@Repository("userRepository1" )
public class UserRespositoryImp implements UserRepository{
	
	@Autowired
	UserComponent UserComponent = null ;
	
	
	
	@Override
	public void save() {
		UserComponent.toString();
		System.out.println(this.getClass().getName()+" save...持久层...");
	}


}
