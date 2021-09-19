package com.senla.hotel.security.configuration.jwt;

import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Log4j
public class JwtProvider {

    private String jwtSecret = "java";

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT signature.");
        } catch (ExpiredJwtException e) {
            log.info("Expired Jwt token");
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported Jwt token");
        } catch (IllegalArgumentException e) {
            log.info("Jwt token compact of handler are invalid.");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
