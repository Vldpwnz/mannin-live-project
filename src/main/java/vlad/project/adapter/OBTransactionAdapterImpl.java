package vlad.project.adapter;

import org.springframework.stereotype.Service;

import vlad.project.entity.Transaction;
import vlad.project.model.OBTransaction6;

@Service
public class OBTransactionAdapterImpl implements OBTransactionAdapter {

	@Override
	public Transaction getTransaction(OBTransaction6 obTransaction6) {
		
		var transaction = new Transaction();
		
		String type = "No type";
		if(obTransaction6.getCreditDebitIndicator() != null && !obTransaction6.getCreditDebitIndicator().name().isBlank()){
			type = obTransaction6.getCreditDebitIndicator().name();
		}
		transaction.setType(type);
		
		Integer accountNumber = -1;
		if(obTransaction6.getAccountId() != null && obTransaction6.getAccountId().isBlank()) {
			accountNumber = Integer.parseInt(obTransaction6.getAccountId());
		}
		transaction.setAccountNumber(accountNumber);
		
		String currency = "No currency";
		if(obTransaction6.getCurrencyExchange() != null && !obTransaction6.getCurrencyExchange().getUnitCurrency().isBlank() ){
			currency = obTransaction6.getCurrencyExchange().getUnitCurrency();
		}
		transaction.setCurrency(currency);
		
		Double ammount = -1.0;
		if(obTransaction6.getAmount() != null && !obTransaction6.getAmount().getAmount().isBlank()) {
			ammount = Double.parseDouble(obTransaction6.getAmount().getAmount());
		}
		
		
		Double exchangeRate = 1.0;
		if((obTransaction6.getCurrencyExchange() != null && !obTransaction6.getCurrencyExchange().getExchangeRate().toPlainString().isBlank())) {
			exchangeRate = Double.parseDouble(obTransaction6.getCurrencyExchange().getExchangeRate().toPlainString());
		}
		transaction.setAmmount(ammount*exchangeRate);
		
		String merchantName = "No merchant name";
		if(obTransaction6.getMerchantDetails() != null && !obTransaction6.getMerchantDetails().getMerchantName().isBlank()) {
			merchantName = obTransaction6.getMerchantDetails().getMerchantName();
		}
		
		transaction.setMerchantName(merchantName);
		
		return transaction;
	}
	
	
	
	

}
