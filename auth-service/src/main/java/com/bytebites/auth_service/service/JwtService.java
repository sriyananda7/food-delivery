package com.bytebites.auth_service.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bytebites.auth_service.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(User user) {

    return Jwts.builder()
            .subject(user.getEmail())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
}
private Claims extractAllClaims(String token) {

    return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
}
public String extractEmail(String token) {
    return extractAllClaims(token).getSubject();
}
private Date extractExpiration(String token) {
    return extractAllClaims(token).getExpiration();
}

public boolean isTokenValid(String token, UserDetails userDetails) {

    String email = extractEmail(token);

    return email.equals(userDetails.getUsername())
            && !isTokenExpired(token);
}
private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
}
}
