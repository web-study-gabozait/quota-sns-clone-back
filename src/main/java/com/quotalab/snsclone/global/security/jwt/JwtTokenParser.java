package com.quotalab.snsclone.global.security.jwt;

import com.quotalab.snsclone.global.config.properties.JwtProperties;
import com.quotalab.snsclone.global.enums.JWT;
import com.quotalab.snsclone.global.security.principle.AuthDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenParser {

    private final JwtProperties jwtProperties;
    private final AuthDetailService authDetailService;

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if(bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }

        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailService.loadUserByUsername(getTokenBody(token, JWT.ACCESS).getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Claims getTokenBody(String token, JWT jwt) {
        String key = jwtProperties.getAccessKey();
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
