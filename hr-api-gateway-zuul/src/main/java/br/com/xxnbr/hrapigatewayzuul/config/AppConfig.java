package br.com.xxnbr.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    var jwtConverter = new JwtAccessTokenConverter();

    jwtConverter.setSigningKey("MY-SECRET-KEY");

    return jwtConverter;
  }

  @Bean
  public JwtTokenStore jwtTokenStore() {
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

}