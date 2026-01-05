package noauth_client.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LessonsController {

    private final RestClient restClient;

    public LessonsController(RestClient restClient) {this.restClient = restClient;}

    @GetMapping("/lessons")
    public String fetchLessons() {
        return restClient.get()
                .uri("/lessons")
                .retrieve()
                .body(String.class);

    }
}
