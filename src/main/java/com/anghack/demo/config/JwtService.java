package com.anghack.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.stereotype.Service;

/**
 *
 * @author anghack
 */
@Service
public class JwtService {
    private static final String SECRET_KEY = "7638792F423F4528482B4D6251655468576D5A7133743677397A24432646294A";

    public String extractUsername(String token) {
        return null;
    }
    
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
