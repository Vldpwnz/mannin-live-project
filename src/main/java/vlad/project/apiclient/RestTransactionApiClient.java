package vlad.project.apiclient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;
import vlad.project.adapter.OBTransactionAdapter;
import vlad.project.adapter.OBTransactionAdapterImpl;
import vlad.project.entity.Transaction;
import vlad.project.model.OBReadTransaction6;
import vlad.project.model.OBTransaction6;


@Slf4j
@Repository
public class RestTransactionApiClient implements TransactionApiClient {
	
	
	private final WebClient webClient;
	
	
	@Value(value = "${base.url}")
	private String baseUrl;
	
	@Value(value = "${client.id}")
	private String clientId;
	
	@Value(value = "${client.secret}")
	private String secret;
	
	
	private OBTransactionAdapter adapter = new OBTransactionAdapterImpl();
	
	@Autowired
	public RestTransactionApiClient(WebClient.Builder client) {
		this.webClient = client.baseUrl(baseUrl).build();
	}
	
	
	@Override
	public List<Transaction> getTransactionsByAccountNumber(Integer accountNumber) {
		
		OBReadTransaction6 obTransaction = null;
		String encodedCredentials =
				Base64Utils.encodeToString(String.format("%s:%s", clientId, secret).getBytes());
		
		try { 
			obTransaction = webClient
					.post()
					.uri("/oauth/token")
					.header("Authorization", "Basic " + encodedCredentials)
					.body(BodyInserters.fromFormData("grant_type", "client_credentials"))
					.retrieve()
					.bodyToMono(JsonNode.class)
					.flatMap(tokenResponse -> {
						String accessToken = tokenResponse.get("access_token")
								.textValue();
						System.out.println(accessToken);
						return webClient.get()
								.uri("accounts/" + accountNumber + "/transactions")
								.headers(h -> h.setBearerAuth(accessToken))
								.retrieve()
								.bodyToMono(OBReadTransaction6.class);
					})
					.block();
	        } catch (Exception ex) {
	        	System.out.println(ex.getMessage());
	        	System.out.println(baseUrl);
	        	System.out.println(clientId + " " + secret);
	        	
	        }

	        if (obTransaction == null || obTransaction.getData() == null) {
	            return Collections.emptyList();
	        }

	        return obTransaction.getData()
	                .getTransaction()
	                .stream()
	                .map(adapter::getTransaction).collect(Collectors.toList());
	}
	
	

}
