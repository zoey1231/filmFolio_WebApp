//package com.example.movie.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.jwt.JwtException;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final String secret;
//
//    public JwtAuthenticationFilter(String secret) {
//        this.secret = secret;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException, ServletException, IOException {
//        String header = request.getHeader("Authorization");
//
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//
//            try {
//                Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//
//                String username = claimsJws.getBody().getSubject();
//                List<String> authorities = (List<String>) claimsJws.getBody().get("authorities");
//
//                Set<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toSet());
//
//                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            } catch (JwtException e) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//                return;
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
