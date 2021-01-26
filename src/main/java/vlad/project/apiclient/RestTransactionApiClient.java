package vlad.project.apiclient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import vlad.project.adapter.OBTransactionAdapter;
import vlad.project.adapter.OBTransactionAdapterImpl;
import vlad.project.entity.Transaction;
import vlad.project.model.OBReadTransaction6;
import vlad.project.model.OBTransaction6;

@Repository
public class RestTransactionApiClient implements TransactionApiClient {
	
	
	private final WebClient webClient;
	
	
	private OBTransactionAdapter adapter = new OBTransactionAdapterImpl();
	
	@Autowired
	public RestTransactionApiClient(WebClient client) {
		this.webClient = client;
	}


	
	
	
	@Override
	public List<Transaction> getTransactionsByAccountNumber(Integer accountNumber) {
		 OBReadTransaction6 obTransaction = null;
		 try {
			 obTransaction = webClient.get()
	                    .uri("accounts/" + accountNumber + "/transactions")
	                    .retrieve()
	                    .bodyToMono(OBReadTransaction6.class)
	                    .block()
	            ;
	        } catch (Exception ex) {
	        		
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
