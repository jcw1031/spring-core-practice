package woopaca.practice.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final Long expireTimeMs = 1000 * 60 * 60L; // 1시간

    public static String createToken(Long id, String username, SecretKey secretKey) {
        Claims claims = Jwts.claims(); // 일종의 Map
        claims.put("username", username);
        claims.put("id", id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String getUsername(String token, SecretKey secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("username", String.class);
    }

    public static boolean isExpired(String token, SecretKey secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
