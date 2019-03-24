package com.mmd.mmdshop;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @ClassName Shop8001_App.java
 * @author QJH
 * @version 1.0
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@MapperScan("com.mmd.mmdshop.mapper")
public class Shop8002_App
{
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(Shop8002_App.class, args);
	}
	
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl(){
		JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost("smtp.qq.com");
        sender.setPort(465);
        sender.setUsername("3342064066@qq.com");
        sender.setPassword("fbgqjtxwbgticice"); // 这里要用邀请码，不是你登录邮箱的密码

        Properties pro = System.getProperties(); // 下面各项缺一不可
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.ssl.enable", "true");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        sender.setJavaMailProperties(pro);
        
		return sender;
	}
}
