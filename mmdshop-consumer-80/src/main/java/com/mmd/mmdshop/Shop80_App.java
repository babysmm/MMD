package com.mmd.mmdshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
	* 
	* @ClassName Shop80_App.java
	* @author QJH
	* @version 1.0
*/
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Shop80_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(Shop80_App.class, args);
	}
}
