package com.quotalab.snsclone.global.security.jwt;

import com.quotalab.snsclone.global.config.properties.JwtProperties;
import com.quotalab.snsclone.global.enums.JWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtTokenParser jwtTokenParser;
    private final JwtProperties jwtProperties;

    public String generateToken(Long seq, JWT jwt) {
        return generateToken(seq, jwtProperties.getAccessExp(), jwt);
    }

    private String generateToken(Long seq, Long exp, JWT jwt) {
        String key = jwtTokenParser.getKeyByJwt(jwt);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(Long.toString(seq))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 10000))
                .compact();
    }


}
