package com.evaluacion.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTToken {

	private static final String SECRET = "MySecretKey";
	private static final String PREFIX = "Bearer ";
	private static final int EXPIRATION = 600000;
	
	public static String getJWTToken(String email, String id) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(email)
				.setSubject(id)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))				
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

		return PREFIX + token;
	}	
}
