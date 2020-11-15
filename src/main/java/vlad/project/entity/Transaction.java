package vlad.project.entity;

import lombok.Data;

@Data
public class Transaction {
	
	private String type;
	private String accountNumber;
	private String currency;
	private int ammount;
	private String merchantName;
	private String merchantLogo;
	
	

}
