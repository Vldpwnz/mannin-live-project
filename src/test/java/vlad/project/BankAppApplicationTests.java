package vlad.project;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vlad.project.service.TransactionService;

@SpringBootTest
class BankAppApplicationTests {
	
	@Autowired
	TransactionService transactionService;

	@Test
	void testIfCollectionOfTransactionIsNotEmpty() {
	
	}

}
