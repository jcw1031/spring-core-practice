package woopaca.practice.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenUtil {
    public static String createToken(String username, SecretKey key, long expireTimeMs) {
        Claims claims = Jwts.claims(); // 일종의 Map
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expireTimeMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
