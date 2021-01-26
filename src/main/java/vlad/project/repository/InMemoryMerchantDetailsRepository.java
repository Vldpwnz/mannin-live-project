package vlad.project.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository
public class InMemoryMerchantDetailsRepository implements MerchantDetailsRepository{

	@Override
	public Optional<String> getMerchantLogo(String merchantName) {
		
		if(merchantName != null) {
			return Optional.of(merchantName + ".png"); 
		}
		return Optional.empty();
	}

}
