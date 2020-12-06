package vlad.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


public class TransactionServiceTest {
	
	
	TransactionService transactionService = new TransactionService();;

	@Test
	void testIfCollectionOfTransactionIsNotEmpty() {
		
		assertEquals(3, transactionService.findAllByAccountNumber(12345).size());
	}

}

