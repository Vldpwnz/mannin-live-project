package vlad.project.adapter;

import org.springframework.stereotype.Service;

import vlad.project.entity.Transaction;
import vlad.project.model.OBTransaction6;

@Service
public class OBTransactionAdapterImpl implements OBTransactionAdapter {

	@Override
	public Transaction getTransaction(OBTransaction6 obTransaction6) {
		
		
		String type = "No type";
		if(obTransaction6.getCreditDebitIndicator() != null && !obTransaction6.getCreditDebitIndicator().name().isBlank()){
			type = obTransaction6.getCreditDebitIndicator().name();
		}
		
		Integer accountNumber = -1;
		if(obTransaction6.getAccountId() != null && obTransaction6.getAccountId().isBlank()) {
			accountNumber = Integer.parseInt(obTransaction6.getAccountId());
		}
		
		String currency = "No currency";
		if(obTransaction6.getCurrencyExchange() != null && !obTransaction6.getCurrencyExchange().getUnitCurrency().isBlank() ){
			currency = obTransaction6.getCurrencyExchange().getUnitCurrency();
		}
		
		Double ammount = -1.0;
		if(obTransaction6.getAmount() != null && !obTransaction6.getAmount().getAmount().isBlank()) {
			ammount = Double.parseDouble(obTransaction6.getAmount().getAmount());
		}
		
		Double exchangeRate = 1.0;
		if((obTransaction6.getCurrencyExchange() != null && !obTransaction6.getCurrencyExchange().getExchangeRate().toPlainString().isBlank())) {
			exchangeRate = Double.parseDouble(obTransaction6.getCurrencyExchange().getExchangeRate().toPlainString());
		}
		
		String merchantName = "No merchant name";
		if(obTransaction6.getMerchantDetails() != null && !obTransaction6.getMerchantDetails().getMerchantName().isBlank()) {
			merchantName = obTransaction6.getMerchantDetails().getMerchantName();
		}
		
		return new Transaction(type, accountNumber, currency, (ammount*exchangeRate), merchantName, "");
	}
	
	
	
	

}
