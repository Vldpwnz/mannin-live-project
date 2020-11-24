package vlad.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vlad.project.entity.Transaction;
import vlad.project.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions/{accountNumber}")
	public List<Transaction> findTransactionsByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
		return transactionService.findAllByAccountNumber(accountNumber);
			
	}

}
