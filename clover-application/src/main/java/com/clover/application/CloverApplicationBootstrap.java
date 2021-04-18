package com.clover.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @InterfaceName: CloverApplicationBootstrap
 * @Description:
 * @Author: Clover
 * @Date: 2021.03.24
 * Version: 1.0
 */
@SpringBootApplication
public class CloverApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloverApplicationBootstrap.class, args);
    }
    //RestTemplate 默认是ISO-8859-1 需要使用StringHttpMessageConverter转换
    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        //得到消息转换器
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        //指定StringHttpMessageConverter消息转换器的字符集为utf-8
        messageConverters.set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return  restTemplate;
    }
}
