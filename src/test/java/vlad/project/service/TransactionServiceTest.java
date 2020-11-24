package vlad.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class TransactionServiceTest {
	
	
	TransactionService transactionService = new TransactionService();;

	@Test
	void testIfCollectionOfTransactionIsNotEmpty() {
		
		assertEquals(3, transactionService.findAllByAccountNumber(12345).size());
	}

}

