package com.cognizant.spring_learn.controller;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostConstruct
    public void init() {
        logger.info("AuthenticationController initialized");
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Received authentication request");

        try {
            String base64Credentials = authHeader.substring("Basic ".length());
            String decoded = new String(Base64.getDecoder().decode(base64Credentials));
            String username = decoded.substring(0, decoded.indexOf(":"));
            logger.info("Decoded");
            
            
            logger.debug("Authenticated user: {}", username);

            String token = generateJwtToken(username);

            logger.info("Generated JWT for user: {}", username);
            return Collections.singletonMap("token", token);

        } catch (Exception e) {
            logger.error("Failed to authenticate or generate token", e);
            throw new RuntimeException("Invalid Authorization Header");
        }
    }

    private String generateJwtToken(String username) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 60 * 60 * 1000)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();
    }

}