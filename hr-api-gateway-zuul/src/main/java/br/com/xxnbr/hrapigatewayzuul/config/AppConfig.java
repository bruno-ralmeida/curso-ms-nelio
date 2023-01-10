package br.com.xxnbr.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

  @Value("${jwt.secret}")
  private String JWT_SECRET;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    var jwtConverter = new JwtAccessTokenConverter();

    jwtConverter.setSigningKey(JWT_SECRET);

    return jwtConverter;
  }

  @Bean
  public JwtTokenStore jwtTokenStore() {
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

}