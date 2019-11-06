package com.iihtibm.sba.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author savagelee
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends JsonWebTokenSecurityConfig {

	@Override
	protected void setupAuthorization(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/v2/api-docs", "/swagger-ui.html", "/swagger-resources/**").permitAll()
		.antMatchers("/actuator/**", "/hystrix", "/hystrix/**", "/favicon.ico", "/webjars/**", "/proxy.stream**").permitAll()
		.antMatchers("/trainings/findAvgRating/**", "/trainings/findByMentorIdSkillId/**").permitAll()
		.anyRequest().authenticated();
	}
}
