package vlad.project.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import vlad.project.entity.Transaction;
import vlad.project.model.OBTransaction6;

@SpringBootTest
public class OBTransactionAdapterTest {
	
	@Mock
	OBTransaction6 obTransaction6;
	
	@InjectMocks
    private OBTransactionAdapter obTransactionAdapter = new OBTransactionAdapterImpl();
	
	@BeforeEach
	    void setMockOutput() {
	        when(obTransaction6.getAmount()).thenReturn(null);
	    }
	
	@Test
	public void testAdapterMethodForValidity() {
		Transaction transaction = obTransactionAdapter.getTransaction(obTransaction6);
		assertEquals(-1.0, transaction.getAmmount());
	}

}
