package rubiya.oauth2.jwt;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

   /* private final String SECRET = "your-very-strong-secret-key";

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 min
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public ResponseCookie createJwtCookie(String token) {
        return ResponseCookie.from("access_token", token)
                .httpOnly(true)
                .secure(true)           // set false only for localhost
                .path("/")
                .maxAge(15 * 60)
                .build();
    }*/
}
