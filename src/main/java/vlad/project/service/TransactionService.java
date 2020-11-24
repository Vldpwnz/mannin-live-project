package vlad.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vlad.project.entity.Transaction;

@Service
public class TransactionService {
	
	public List<Transaction> findAllByAccountNumber(int accountNumber){
		
		List<Transaction> transactions= new ArrayList<Transaction>();
		transactions.add(new Transaction("credit", 1234567, "USD", 100.00, "acme", "acme.png"));
		transactions.add(new Transaction());
		transactions.add(new Transaction());
		return transactions;
		
	}

}
