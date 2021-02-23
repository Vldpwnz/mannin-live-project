package vlad.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthConfigClass extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public void configure(
			AuthorizationServerEndpointsConfigurer endpoints) {
		
		endpoints.authenticationManager(authManager);
	}

	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("better-banking.io")
                .secret("DHmn6yjQRWcCNA9P")
                .authorizedGrantTypes("password")
                .scopes("read");
    }
	
	
	
	
	

}
