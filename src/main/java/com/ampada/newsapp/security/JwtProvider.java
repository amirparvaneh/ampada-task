package com.ampada.newsapp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

    public static final int EXPIRATION_TIME = 1000 * 60 * 60 * 6;

    @Deprecated
    public static final String SECRET = "SecretSecretSecretSecretSecretSecretSecretSecret";

    private KeyStore keyStore;

    @PostConstruct
    void populateKeyStore() {
        try {
            // todo => make password more secure
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/key-demo.jks"), "@ampada".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("key-demo", "@ampada".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException |
                UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("key-demo").getPublicKey();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String generateToken(UserDetails user) {
        Map<String, ?> claims = new HashMap<>();
        return createToken(claims, user);
    }

    private String createToken(Map<String, ?> claims, UserDetails user) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(new Date(EXPIRATION_TIME + System.currentTimeMillis()))
                .signWith(getPrivateKey())
                .compact();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public boolean validate(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) &&
                !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpireDate(token).before(Date.from(Instant.now()));
    }

    private Date extractExpireDate(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getPublicKey()) // version 2
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
