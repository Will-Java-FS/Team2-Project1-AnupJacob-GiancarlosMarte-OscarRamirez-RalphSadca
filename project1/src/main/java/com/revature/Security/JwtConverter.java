package com.revature.Security;

import com.revature.Models.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtConverter {

    // Signing key
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // "Configurable" constants
    private final String ISSUER = "Ecommerce";                       // We should come up with a name tbh
    private final int EXPIRATION_MINUTES = 50;                          // Can change later
    private final int EXPIRATION_MILLIS = EXPIRATION_MINUTES * 60 * 1000;

    public String getTokenFromUser(User user) {
        String authorities = null;      // Admin/User/Guest
                                        // @TODO: need user model to add Collection<GrantedAuthority> auths
                                        // @TODO: will review first

        return Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(user.getUsername())
                .claim("user_id", user.getUsername())
                .claim("authorities", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key)
                .compact();
    }

    public User getUserFromToken(String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        try {
            // 4. Use JJWT classes to read a token.
            Jws<Claims> jws = Jwts.parserBuilder()
                    .requireIssuer(ISSUER)
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.substring(7));

            String username = jws.getBody().getSubject();
            int userId = (int)jws.getBody().get("user_id");
            String authStr = (String) jws.getBody().get("authorities");

            // @TODO: return new user
//            return new User()
            return null;
        } catch (JwtException e) {
            // 5. JWT failures are modeled as exceptions
            System.out.println(e.getMessage());
        }

        return null;
    }
}
