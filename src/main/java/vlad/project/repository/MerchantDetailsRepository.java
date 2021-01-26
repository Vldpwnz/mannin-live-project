package vlad.project.repository;

import java.util.Optional;

public interface MerchantDetailsRepository {
	
	Optional<String> getMerchantLogo(String merchantName);
}
