package org.encore.apartment.community.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.val;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final String [] allowedUrls = {
		"/",
		"/api-docs/**",
		"/swagger-ui/**",
		"/v3/**", "/sign-in",
		"/user/sign-up",
		"/user/**",
		"/apartment/**",
		"/member/**"
	};

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(CsrfConfigurer<HttpSecurity>::disable)
			.authorizeHttpRequests(requests ->
				requests.requestMatchers(allowedUrls).permitAll()	// requestMatchers의 인자로 전달된 url은 모두에게 허용
					.anyRequest().authenticated()	// 그 외의 모든 요청은 인증 필요
			)
			.sessionManagement(sessionManagement ->
				sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)	// 세션을 사용하지 않으므로 STATELESS 설정
			.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
