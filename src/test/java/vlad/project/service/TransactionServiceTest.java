package vlad.project.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.anyInt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import vlad.project.apiclient.RestTransactionApiClient;
import vlad.project.entity.Transaction;
import vlad.project.repository.InMemoryMerchantDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
	
	@Mock
	private InMemoryMerchantDetailsRepository merchantDetails;
	
	@Mock
	private RestTransactionApiClient transactionClient;
	
	@InjectMocks
	private TransactionService transactionService;
	
	@BeforeEach
	void setUp() {
		when(transactionClient.getTransactionsByAccountNumber(anyInt())).thenReturn(List.of(new Transaction()));
	}
	
	

	@Test
	void testIfCollectionOfTransactionIsNotEmpty() {
		
		assertEquals(1, transactionService.findAllByAccountNumber(12345).size());
	}

}

