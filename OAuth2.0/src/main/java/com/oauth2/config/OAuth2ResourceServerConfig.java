package com.oauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${oauth.resourceId}")
	private String RESOURCE_ID;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}
	
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/token").permitAll()
		               .antMatchers("/admin").access("hasRole('ADMIN')")
			           .antMatchers("/user").access("hasAnyRole('USER','ADMIN')")
			           .and().exceptionHandling()
			           .accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}