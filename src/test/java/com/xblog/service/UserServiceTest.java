package com.xblog.service;

import com.xblog.BlogApiApplicationTests;
import com.xblog.modules.user.entity.User;
import com.xblog.modules.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BlogApiApplicationTests{
//
	@Autowired
	private UserService userService;
//
//
/*	List<User> findAll();
	
	User findByAccount(String account);

	User getUserById(Long id);

	Long saveUser(User user);

	Long updateUser(User user);

	void deleteUserById(Long id);*/
//
	@Test
	public void saveUserTest() {
		User user = userService.queryUserByAccount("zr");
		System.out.println(user);
	}




//
//	@Test
//	public void getUserById() {
//		Long id = 3L;
//		User u = userService.getUserById(id);
//		System.out.println(u);
//	}
//
//	@Test
//	public void findAllTest() {
//		List<User> us = userService.findAll();
//		System.out.println(us);
//	}
//
//	@Test
//	public void updateUserTest() {
//		User u = new User();
//		Long id = 3L;
//		u.setId(id);
//		u.setNickname("史明辉222");
//		userService.updateUser(u);
//	}
//
//	@Test
//	public void deleteTest() {
//		Long id = 3L;
//		userService.deleteUserById(id);
//
//	}
	
}
