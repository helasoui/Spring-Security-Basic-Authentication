package com.project.auth.securityconfigurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustonWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.inMemoryAuthentication()
									.withUser("hela")
									.password("{noop}password")
									.roles("ADMIN");
		authenticationManagerBuilder.inMemoryAuthentication()
									.withUser("souissi")
									.password("{noop}password")
									.roles("USER");
	}

	// security for all apis
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception{
	 * http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().
	 * and().httpBasic(); }
	 */

	// security based on URL
	/*protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/api/test").fullyAuthenticated().and().httpBasic();
	}*/
	
	
	//based on role
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/api/test").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
		}
	
	/*@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}*/

}
