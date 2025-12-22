public class JwtUtil {

    private final Key key;
    private final long validity;

    public JwtUtil(String secret, long validityMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validity = validityMs;
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(key)
                .compact();
    }

    public Jws<Claims> validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
