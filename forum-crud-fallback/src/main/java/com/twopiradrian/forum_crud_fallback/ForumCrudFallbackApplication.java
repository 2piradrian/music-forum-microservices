package com.twopiradrian.forum_crud_fallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ForumCrudFallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumCrudFallbackApplication.class, args);
	}

}
