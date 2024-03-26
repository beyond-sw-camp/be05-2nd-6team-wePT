package org.encore.apartment.community.domain.security.filter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.security.provider.TokenProvider;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Order(0) // int 범위 내에서 의존성 주입 우선순위를 정함
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private final TokenProvider tokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
		ServletException, IOException {
		try {
			String token = parseBearerToken(request);
			User user = parseUserSpecification(token);
			AbstractAuthenticationToken authenticated = UsernamePasswordAuthenticationToken.authenticated(user, token, user.getAuthorities());
			authenticated.setDetails(new WebAuthenticationDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticated);
		} catch (Exception e) {
			request.setAttribute("exception", e); // try-catch 로 예외를 감지하여 request 에 저장
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * HTTP 요청의 헤더에서 Bearer 토큰을 추출하여 사용자 정보를 파싱하고, SecurityContextHolder에 인증 객체를 저장
	 * 헤더에 Authorization이 존재하지 않거나 접두어가 Bearer가 아니면 null을 반환
	 * @param request
	 * @return
	 */
	private String parseBearerToken(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
			.filter(token -> token.substring(0, 7).equalsIgnoreCase("Bearer "))
			.map(token -> token.substring(7))
			.orElse(null);
	}

	private User parseUserSpecification(String token) {
		String[] split = Optional.ofNullable(token)
			.filter(subject -> subject.length() >= 10)
			.map(tokenProvider::validateTokenAndGetSubject)
			.orElse("anonymous:anonymous")
			.split(":");

		return new User(split[0], "", List.of(new SimpleGrantedAuthority(split[1])));
	}
}
