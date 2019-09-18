package com.pixogram.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.article.admin.entity.User;
import com.article.admin.repo.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
	@Autowired
	private static UserRepo controller;
	
	@Autowired
	UserRepo repo;
	 @Test		
	    public void userRepo4(){	
		 List<User> gfg = new ArrayList<User>();
		 
		
	    
	 }
	 @Test		
	    public void myRepo4(){	
		 ArrayList<Optional> gfg = new ArrayList<Optional>();
			
	    
	 }
	 @Test		
	    public void myRepo(){	
	       		
	    }
	 @Test		
	    public void myRepo1(){	
		 
		 		
	    }
	
	
	
	
	

}
