package vlad.project.apiclient;

import java.util.List;

import vlad.project.entity.Transaction;

public interface TransactionApiClient {
	
	List<Transaction> getTransactionsByAccountNumber(Integer accountNumber);

}
