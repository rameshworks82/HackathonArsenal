package org.rkworks.demo;

import org.rkworks.demo.filter.MDCLog4JFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebAppApplication.class, args);
	}
	
	
	 @Bean
	    public FilterRegistrationBean mdcFilter() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new MDCLog4JFilter());
	        registration.addUrlPatterns("/*");
	        return registration;
	    }
}
