package vlad.project.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


public class Transaction {
	
	private String type;
	private int accountNumber;
	private String currency;
	private double ammount;
	private String merchantName;
	private String merchantLogo;
	
	
	public Transaction() {
		
	}
	
	public Transaction(String type, int accountNumber, String currency, double ammount, String merchantName,
			String merchantLogo) {
		this.type = type;
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.ammount = ammount;
		this.merchantName = merchantName;
		this.merchantLogo = merchantLogo;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public double getAmmount() {
		return ammount;
	}
	
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	public String getMerchantLogo() {
		return merchantLogo;
	}
	
	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	
	
	
	

}
