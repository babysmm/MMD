package com.mmd.mmdshop.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
	* bean≈‰÷√¿‡
	* @ClassName ConfigBean.java
	* @author QJH
	* @version 1.0
*/

@Configuration
public class ConfigBean {
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
