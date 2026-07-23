package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication //@Configuration + @EnableAutoConfiguration + @ComponentScan
@EnableDiscoveryClient
@EnableFeignClients
public class SbEmsApplication {// Entry Point

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}
