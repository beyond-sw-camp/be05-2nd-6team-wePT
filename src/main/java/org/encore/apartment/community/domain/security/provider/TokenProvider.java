package org.encore.apartment.community.domain.security.provider;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@PropertySource("classpath:jwt.yml")
@Service
public class TokenProvider {
	private final String secretKey;
	private final long expirationHours;
	private final String issuer;

	public TokenProvider(
		@Value("${secret-key}") String secretKey,
		@Value("${expiration-hours}") long expirationHours,
		@Value("${issuer}") String issuer
	) {
		this.secretKey = secretKey;
		this.expirationHours = expirationHours;
		this.issuer = issuer;
	}

	/**
	 * JWT 토큰 생성
	 * @param userSpecification - 사용자 정보
	 * HS512 알고리즘을 사용하여 secretKey 를 이용해 서명
	 * setSubject() - JWT 토큰 제목
	 * setIssuer() - JWT 토큰 발급자
	 * setIssuedAt() - JWT 토큰 발급 시간
	 *
	 * @return JWT 토큰
	 */

	public String createToken(String userSpecification) {
		return Jwts.builder()
			.signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName()))
			.setSubject(userSpecification)
			.setIssuer(issuer)
			.setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
			.setExpiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))
			.compact();
	}

	/**
	 * JWT 토큰 유효성 검사 및 제목 반환(복호화 함수)
	 * @param token
	 * @return
	 */

	public String validateTokenAndGetSubject(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(secretKey.getBytes())
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

}
