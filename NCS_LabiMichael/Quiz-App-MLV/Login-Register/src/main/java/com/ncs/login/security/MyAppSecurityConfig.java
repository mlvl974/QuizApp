package com.ncs.login.security;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.ncs.login.service.AppUserServiceImpl;

//import com.mkj.securepro.service.AppUserServiceImpl;

@Configuration
@EnableWebSecurity
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(" --->> configure HTTp method - start");
		 http.
		 //	csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		 //	.and().
		 	csrf().disable().cors().disable().
			authorizeRequests().

			antMatchers("/abc-university/public/**").permitAll().
			antMatchers("/abc-university/admin/**").hasAuthority("admin").
			antMatchers("/abc-university/student/**").hasAnyAuthority("student").
			
			anyRequest().authenticated().and().
			sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
	
		 
		 // ----- configure JWTFilters for all next request
		 
		 
		 System.out.println(" --->> configure HTTp method - End");
	} //end httpSecurity configuration

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		System.out.println("=============>> inside security Config class - method auth manager builder "+auth);
		auth.authenticationProvider(authenticationProvider());
		//auth.userDetailsService(null)
		
	}

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();
	}
	
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new AppUserServiceImpl();
    }
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
		 
		
		 
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        System.out.println("=============>> Inside Security Config class DAO auth provider "+authProvider);
	        return authProvider;
	 }
	
	 @Bean
	 public AuthenticationManager authenticationManagerBean()throws Exception
	 {
		 System.out.println(" --->> Inside AuthenticationManager @Bean ");
		 return super.authenticationManagerBean();
	 }
	 

}//end class
