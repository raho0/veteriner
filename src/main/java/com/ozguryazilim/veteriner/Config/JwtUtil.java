package com.ozguryazilim.veteriner.Config;

import com.ozguryazilim.veteriner.Entity.OwnerEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("$(jwt.secret)")
    private String SECRET_KEY;

    public String generateToken(OwnerEntity owner) {
        Date expireAt = new Date(System.currentTimeMillis() + 900 * 1000);
        return Jwts.builder()
                .setSubject(owner.getName())
                .claim("role",owner.getRole())
                .setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new Exception("invalid token");
        }
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
