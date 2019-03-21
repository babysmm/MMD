package com.mmd.mmdshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mmd.mmdshop.utils.QiNiuYunUtils;
import com.mmd.mmdshop.utils.RedisUtil;
import com.mmd.mmdshop.utils.SerializeUtil;
import com.mmd.mmdshop.utils.SnowflakeIdWorker;

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
	public QiNiuYunUtils getQiNiuYunUtils() {
		return new QiNiuYunUtils();
	}
	
	@Bean
	public SnowflakeIdWorker getSnowflakeIdWorker() {
		return new SnowflakeIdWorker(1, 1);
	}
	
	@Bean
	public RedisUtil getRedisUtil() {
		return new RedisUtil();
	}
	
	@Bean SerializeUtil getSerializeUtil() {
		return new SerializeUtil();
	}
}
