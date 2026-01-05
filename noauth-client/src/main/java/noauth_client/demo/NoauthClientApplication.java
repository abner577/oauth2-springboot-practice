package noauth_client.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class NoauthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoauthClientApplication.class, args);
	}

	@Bean
	public RestClient restClient() {
		return RestClient.builder()
				.baseUrl("http://localhost:8081")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultStatusHandler(HttpStatusCode::is4xxClientError, (request, response) -> {
					if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
						throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized access to lessons API");
					}
					throw new ResponseStatusException(response.getStatusCode(), "Client error occurred");
				})
				.defaultStatusHandler(HttpStatusCode::is5xxServerError, (request, response) -> {
					throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
							"Downstream service error: " + response.getStatusCode());
				})
				.build();
	}
}
