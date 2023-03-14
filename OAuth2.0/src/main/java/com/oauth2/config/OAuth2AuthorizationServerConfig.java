package com.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${oauth.clientId}")
	private String clientID;

	@Value("${oauth.clientSecret}")
	private String clientSecret;

	@Value("${oauth.accessTokenValidity}")
	private int accessTokenValidity;

	@Value("${oauth.refreshTokenValidity}")
	private int refreshTokenValidity;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}

	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientID).secret(passwordEncoder.encode(clientSecret))
				.authorizedGrantTypes("password", "refresh_token").scopes("user_info")
				.accessTokenValiditySeconds(accessTokenValidity).refreshTokenValiditySeconds(refreshTokenValidity);
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

}
