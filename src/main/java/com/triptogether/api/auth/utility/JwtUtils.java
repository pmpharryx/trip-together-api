package com.triptogether.api.auth.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.triptogether.api.auth.exception.MissingTokenException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.*;


public class JwtUtils {

    private static final String SECRET = "secret_key";

    private static final long EXPIRATION = 3600L;

    private static final String BEARER_PREFIX = "Bearer ";

    public static String createToken(UUID userId){
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg","HS256");
        headerMap.put("typ","JWT");

        return JWT.create()
                .withHeader(headerMap)
                .withClaim("userId", userId.toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION *1000))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static UUID getUserId() {

        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String authorizationHeader = request.getHeader("Authorization");
        String token = extractToken(authorizationHeader);

        if (token == null || token.isBlank()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("authorizationHeader", "Missing Token Exception.");
            throw new MissingTokenException("Authorization token is missing.", errors);
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            if (jwt != null) {
                Claim audience = jwt.getClaim("userId");
                if (!audience.isMissing() && !audience.isNull() && !audience.asString().isEmpty()) {
                    return UUID.fromString(audience.asString()) ;
                }
            }
        } catch (IllegalArgumentException | JWTVerificationException e) {
                e.printStackTrace();
        }
        return null;
    }

    public static void verify(){

        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String authorizationHeader = request.getHeader("Authorization");
        String token = extractToken(authorizationHeader);

        if (token == null || token.isBlank()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("authorizationHeader", "Missing Token Exception.");
            throw new MissingTokenException("Authorization token is missing.", errors);
        }
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            if (jwt != null) {
                Date expiresAt = jwt.getExpiresAt();
                System.out.println("expires at: " + expiresAt.toString() + ", current date: " + new Date());
                if (expiresAt.before(new Date())) {
                    // Token has expired
                    throw new JWTVerificationException("Token has expired.");
                }

                Claim audience = jwt.getClaim("userId");
                if (audience.isMissing() && audience.isNull() && audience.asString().isEmpty()) {
                    throw new JWTVerificationException("Token claim is missing.");
                }
            }
            else
                throw new JWTVerificationException("Token verification failed.");

        } catch (IllegalArgumentException | JWTVerificationException e) {
            e.printStackTrace();
        }
    }

    public static String extractToken(String authorizationHeader){
        if(authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)){
            return authorizationHeader.substring(BEARER_PREFIX.length());
        }
        return null;
    }
}

