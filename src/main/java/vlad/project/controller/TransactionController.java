package vlad.project.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vlad.project.entity.Transaction;
import vlad.project.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/{accountNumber}")
    @PostFilter(value = "hasAuthority(filterObject.accountNumber)")
    public List<Transaction> findAllByAccountNumber(@PathVariable("accountNumber") final Integer accountNumber
    , Principal principal
    ) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }

}
