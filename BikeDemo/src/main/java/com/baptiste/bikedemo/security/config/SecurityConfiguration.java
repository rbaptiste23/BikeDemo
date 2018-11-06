package com.baptiste.bikedemo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 auth.inMemoryAuthentication()
//	               .withUser("riley").password("test").roles("USER").and()
//	               .withUser("demo").password("test2").roles("ADMIN");
//	 
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("riley").password("test").roles("USER").build());
		manager.createUser(
				User.withDefaultPasswordEncoder().username("admin").password("test2").roles("ADMIN").build());
		return manager;
	}

	/*
	 * Thus far our WebSecurityConfig only contains information about how to
	 * authenticate our users. How does Spring Security know that we want to require
	 * all users to be authenticated? How does Spring Security know we want to
	 * support form based authentication? The reason for this is that the
	 * WebSecurityConfigurerAdapter provides a default configuration in the
	 * configure(HttpSecurity http) method that looks like:
	 */

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()

				.antMatchers("/rest/**", "/Display", "/logout").hasRole("USER")
				.antMatchers("/Create", "/Save", "/Delete", "/logout").hasRole("ADMIN").anyRequest()
				// .permitAll()
				.fullyAuthenticated().and().httpBasic();

		httpSecurity.formLogin().loginPage("/login").permitAll();
		httpSecurity.logout();

		httpSecurity.csrf().disable();
//
////			httpSecurity
////		        .logout()                                                                
////		            .logoutUrl("/my/logout")                                                 
////		            .logoutSuccessUrl("/my/index")                                           
////		            .logoutSuccessHandler(logoutSuccessHandler)                              
////		            .invalidateHttpSession(true)                                             
////		            .addLogoutHandler(logoutHandler)                                          
////		            .deleteCookies(cookieNamesToClear)                                       
////		            .and()
//
	}
}
