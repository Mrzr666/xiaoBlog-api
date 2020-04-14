package com.xblog.result;

import com.alibaba.fastjson.JSON;
import com.xblog.common.result.Result;
import com.xblog.modules.user.entity.User;
import org.junit.Test;

public class ResultTest {
	
//
//	@Test
//	public void simpleTest() {
//		Result s = Result.success();
//		s.simple().put("user_id", 123456);
//
//		String ss = JSON.toJSONString(s);
//		System.out.println(ss);
//
//	}
//
	@Test
	public void entityTest() {
		User u = new User();

		u.setId(1L);
		u.setAccount("a");

		Result s = Result.success(u);
		String ss = JSON.toJSONString(s);
		System.out.println(ss);
	}
//
//	@Test
//	public void ListTest() {
//		User u = new User();
//		u.setId(1L);
//		u.setAccount("a");
//
//		User u2 = new User();
//		u2.setId(2L);
//		u2.setAccount("b");
//
//		List<User> users = Arrays.asList(u,u2);
//
//		Result s = Result.success(users);
//		String ss = JSON.toJSONString(s);
//		System.out.println(ss);
//	}
}
