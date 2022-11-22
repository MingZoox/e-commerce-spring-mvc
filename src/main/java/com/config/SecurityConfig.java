package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan("com")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select memberLogin,memberPass,memberStatus from member where memberLogin=?")
				.authoritiesByUsernameQuery("select memberLogin,ROLE from member where memberLogin=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/manages/**").hasRole("ADMIN").and().authorizeRequests()
				.antMatchers("/cart/**").hasAnyRole("ADMIN", "USER").anyRequest().permitAll().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/submitlogin").defaultSuccessUrl("/cart/loginsuccess")
				.failureUrl("/login?msg=error").usernameParameter("memberLogin").passwordParameter("memberPass").and()
				.exceptionHandling().accessDeniedPage("/error").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}

}
