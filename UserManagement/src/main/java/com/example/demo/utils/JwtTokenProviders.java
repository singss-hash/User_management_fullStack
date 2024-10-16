package com.example.demo.utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProviders {

    @Value("${jwt.secret.key}")
    private String secretKey; // Injected from properties file

    private final long EXPIRATION_TIME = 360;

    // Create token using email and role
    public String createToken(String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)  // Use secretKey here
                .compact();
    }

    // Validate the token
    public Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // Use secretKey here
                .parseClaimsJws(token)
                .getBody();
    }
}


