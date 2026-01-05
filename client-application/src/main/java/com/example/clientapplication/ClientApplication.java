package com.example.clientapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public RestClient restClient(OAuth2AuthorizedClientManager authorizedClientManager) {
		var interceptor = new OAuth2ClientHttpRequestInterceptor(authorizedClientManager);
		return RestClient.builder()
				.requestInterceptor(interceptor)
				.build();
	}

}
