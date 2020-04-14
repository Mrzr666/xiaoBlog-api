package com.xblog.redis;

import com.xblog.BlogApiApplicationTests;
import com.xblog.common.util.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

public class RedisManagerTest extends BlogApiApplicationTests{
//
	@Resource
	private RedisUtils redisManager;
//
//
	@Test
	public void setTest() {
		String k = "zzz";
		String v = "123789";
		redisManager.set(k, v);
	}

	@Test
	public void getTest() {
		Jedis jedis=new Jedis("47.94.34.191", 6379);
		jedis.auth("123456");
		jedis.set("wxf", "我很强");
		String value=jedis.get("wxf");
		System.out.println(value);
		//释放资源
		jedis.close();
	}
//
//	@Test
//	public void deleteTest() {
//		String k = "zzz";
//		redisManager.delete(k);
//		String v = redisManager.get(k,String.class);
//		System.out.println(v);
//	}
	
}
