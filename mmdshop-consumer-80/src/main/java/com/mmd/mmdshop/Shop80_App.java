package com.mmd.mmdshop;

import java.io.IOException;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.mmd.mmdshop.controller.SocketServer;

/**
 * 
 * @ClassName Shop80_App.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Shop80_App
{
	static SocketServer server = null;
	public static void main(String[] args)
	{
		SpringApplication.run(Shop80_App.class, args);
		
		//server = new SocketServer();
		//起socket服务
		//server.startSocketServer(8088);
	}
}
