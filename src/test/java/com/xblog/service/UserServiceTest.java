package com.xblog.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.xblog.BlogApiApplicationTests;
import com.xblog.common.result.Result;
import com.xblog.common.sysconfig.service.ConfigService;
import com.xblog.common.util.MailUtils;
import com.xblog.common.util.RedisUtils;
import com.xblog.modules.line.entity.Line;
import com.xblog.modules.line.service.LineService;
import com.xblog.modules.user.entity.User;
import com.xblog.modules.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTest extends BlogApiApplicationTests{
//
	@Autowired
	private UserService userService;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private ConfigService configService;
	@Autowired
	private LineService lineService;
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


	@Test
	public void redisTest(){
		redisUtils.set("test001","hello");

		String value = (String) redisUtils.get("test001");

		System.out.println(value);
	}

	@Test
	public void lineAddTest(){
		Line line = new Line();
		line.setContext("123213123213213421412");
		line.setDeleted(false);
		line.setCreatedDate(new Date());
		line.setMarkTime(new Date());
		lineService.createLine(line);
	}

	@Test
	public void mailTest(){
		String AccessKeyId = configService.queryValueByKey("AccessKey");
		String AccessKeySecret = configService.queryValueByKey("AccessKeySecret");
		// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", AccessKeyId, AccessKeySecret);
		// 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
		//try {
		//DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
		//} catch (ClientException e) {
		//e.printStackTrace();
		//}
		IAcsClient client = new DefaultAcsClient(profile);
		SingleSendMailRequest request = new SingleSendMailRequest();

		try {
			//request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
			request.setAccountName("xxblog@xiaosyaliyun.club");
			request.setFromAlias("xxblog");
			request.setAddressType(1);
			request.setTagName("xXBlog");
			request.setReplyToAddress(true);
			request.setToAddress("965377356@qq.com");
			//可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
			//request.setToAddress("邮箱1,邮箱2");
			request.setSubject("邮件主题test");
			//如果采用byte[].toString的方式的话请确保最终转换成utf-8的格式再放入htmlbody和textbody，若编码不一致则会被当成垃圾邮件。
			//注意：文本邮件的大小限制为3M，过大的文本会导致连接超时或413错误
			request.setHtmlBody("邮件正文test");
			//SDK 采用的是http协议的发信方式, 默认是GET方法，有一定的长度限制。
			//若textBody、htmlBody或content的大小不确定，建议采用POST方式提交，避免出现uri is not valid异常
			request.setMethod(MethodType.POST);
			//开启需要备案，0关闭，1开启
			//request.setClickTrace("0");
			//如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
			SingleSendMailResponse httpResponse = client.getAcsResponse(request);
		} catch (ServerException e) {
			//捕获错误异常码
			System.out.println("ErrCode : " + e.getErrCode());
			e.printStackTrace();
		}catch (ClientException e) {
			//捕获错误异常码
			System.out.println("ErrCode : " + e.getErrCode());
			e.printStackTrace();
		}
	}

	@Test
	public void configTest(){
		String a = configService.queryValueByKey("AccessKey");
		System.out.println(a);
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
