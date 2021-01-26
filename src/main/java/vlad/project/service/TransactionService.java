package vlad.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import vlad.project.apiclient.RestTransactionApiClient;
import vlad.project.entity.Transaction;
import vlad.project.repository.InMemoryMerchantDetailsRepository;
import vlad.project.repository.MerchantDetailsRepository;


@Service
public class TransactionService {
	
	private RestTransactionApiClient transactionClient;
	private InMemoryMerchantDetailsRepository merchantDetailsRepository;
	
	
	
	
	public TransactionService(RestTransactionApiClient transactionClient,
			InMemoryMerchantDetailsRepository merchantDetailsRepository) {
		
		this.transactionClient = transactionClient;
		this.merchantDetailsRepository = merchantDetailsRepository;
	}




	@CircuitBreaker(name = "transactionService", fallbackMethod = "noTransactionByAccountNumber")
	public List<Transaction> findAllByAccountNumber(int accountNumber){
		
		var transactions = transactionClient.getTransactionsByAccountNumber(accountNumber);
		
		transactions.forEach(transaction -> {
			merchantDetailsRepository.getMerchantLogo(transaction.getMerchantName()).ifPresent(logo -> {
				transaction.setMerchantLogo(logo);
			});
		});
		
		return transactions;
	}
	
	public List<Transaction> noTransactionByAccountNumber(int accountNumber, Throwable throwable){
		
		return Collections.EMPTY_LIST;
	}

}
