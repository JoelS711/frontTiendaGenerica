package Ciclo3.front;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class FrontConfiguration {
	private static final String URL = "http://localhost:8083";
	
 	@Bean
    public WebClient myWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "APPLICATION_JSON")
                .defaultHeader(HttpHeaders.USER_AGENT, "front")
                .build();
    }
}
