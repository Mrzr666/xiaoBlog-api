package com.xblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,})
@MapperScan("com.xblog.modules.**.mapper")
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BlogApiApplication.class);
		app.run(args);
	}
}
