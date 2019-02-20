package com.mmd.mmdshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @ClassName Shop8001_App.java
 * @author QJH
 * @version 1.0
 */

@SpringBootApplication
@MapperScan("com.mmd.mmdshop.mapper")
public class Shop8001_App
{
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(Shop8001_App.class, args);
	}
}
