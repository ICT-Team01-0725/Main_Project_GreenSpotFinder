package com.ict.edu.finalsearchparkwebconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        // /static/ 경로에 대한 요청을 src/main/resources/static 폴더로 매핑
	        registry.addResourceHandler("/static/**")
	                .addResourceLocations("classpath:/static/");
	    }
}