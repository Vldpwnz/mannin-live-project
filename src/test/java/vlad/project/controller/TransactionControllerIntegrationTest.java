package vlad.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vlad.project.service.TransactionService;



@WebMvcTest
public class TransactionControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TransactionService transactionService;
	
	@Test
	public void transactionsEndpointShouldReturnTransactionsViaService() {
		
		
		
	}

}
