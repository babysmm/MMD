package com.mmd.mmdshop.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.baidu.aip.speech.AipSpeech;
import com.mmd.mmdshop.utils.BaiduSpeechSynthesis;
import com.mmd.mmdshop.utils.RedisUtil;
import com.mmd.mmdshop.utils.SerializeUtil;

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
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return restTemplate;
	}
	
	public static final String APP_ID = "15633631";
	public static final String API_KEY = "tBlGGsb2vCEpp9yxEexUN8P9";
	public static final String SECRET_KEY = "NDxrWzofrAIRWlMfkngcmezMVYvfedil";
	
	@Bean
	public AipSpeech getAipSpeech() {
		return new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
	}
	
	@Bean
	public BaiduSpeechSynthesis getBaiduSpeechSynthesis() {
		return new BaiduSpeechSynthesis();
	}
	
	@Bean
	public RedisUtil getRedisUtil() {
		return new RedisUtil();
	}
	
	@Bean SerializeUtil getSerializeUtil() {
		return new SerializeUtil();
	}
	
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
