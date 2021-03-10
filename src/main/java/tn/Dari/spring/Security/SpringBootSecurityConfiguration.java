package tn.Dari.spring.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value("${security.enable-csrf}")
   	private boolean csrfEnabled;

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
	}
}