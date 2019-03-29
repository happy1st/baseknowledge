package com.hikvision.baseknowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BaseknowledgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseknowledgeApplication.class, args);
	}

}
