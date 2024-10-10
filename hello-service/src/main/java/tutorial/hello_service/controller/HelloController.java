package tutorial.hello_service.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class HelloController {
    private final RestClient restClient;

    public HelloController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/hello")
    public String hello() {
        ResponseEntity<String> res = restClient
                .post()
                .uri("https://httpbin.org/post")
                .body("Hello, Cloud!")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);
        return res.getBody();
    }
}
