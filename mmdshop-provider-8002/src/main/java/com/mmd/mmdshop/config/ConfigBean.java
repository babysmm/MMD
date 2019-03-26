package com.mmd.mmdshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mmd.mmdshop.utils.RedisUtil;

/**
 * 
 * @ClassName ConfigBean.java
 * @author MM
 * @version 2.0
 * @date 2019/2/18
 */

@Configuration
public class ConfigBean {
	@Bean
	public RedisUtil getRedisUtil() {
		return new RedisUtil();
	}
}
