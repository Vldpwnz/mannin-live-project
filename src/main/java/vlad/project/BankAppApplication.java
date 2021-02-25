package vlad.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BankAppApplication {
	
	@Value(value = "${base.url}")
	private String baseUrl;

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl(baseUrl)
				.build();
		return webClient;
	}
	

}
