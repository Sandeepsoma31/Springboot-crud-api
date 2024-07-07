package com.manage.users.managment;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.manage.users.managment.users.User;
import com.manage.users.managment.users.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired private UserRepository repo;
	
	@Test
	public void testAddNewUser()  //Testing: Add new to user to db
	{
		User user = new User();
		
		user.setEmail("Alita123@gmail.com");
		user.setPassword("Alita@123");
		user.setUserName("Alita");
		user.setGender("Female");
		
		User savedNewUser = repo.save(user);
		
		Assertions.assertThat(savedNewUser).isNotNull();
		Assertions.assertThat(savedNewUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testAllUsers() //Testing: All Users details
	{
		Iterable<User> users = repo.findAll();
		
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for(User user: users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void testUpdateUser() //Testing: updating any user detail
	{
		Integer userId = 1;
		Optional<User> optionalUser = repo.findById(userId);
		
		User user = optionalUser.get();
		user.setPassword("John#123");   //Updating new password
		
		repo.save(user);
		
		User updatedUser = repo.findById(userId).get();
		Assertions.assertThat(updatedUser.getPassword()).isEqualTo("John#123");
		
	}
	
	@Test
	public void testGetUser() //Testing: get user details
	{
		Integer userId = 1;
		
		Optional<User> getUser = repo.findById(userId);
		
		Assertions.assertThat(getUser).isPresent();
		System.out.println(getUser.get());
	}
	
	@Test
	public void testDeleteUser()
	{
		Integer userId = 2;
		
		repo.deleteById(userId);
		
		Optional<User> getUser = repo.findById(userId);
		Assertions.assertThat(getUser).isNotPresent();
		System.out.println("Users after deleting: "+repo.findAll());
		
	}

}
