package br.com.xxnbr.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.xxnbr.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

  private static Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserFeignClient feignClient;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var response = feignClient.findByEmail(username).getBody();

    if (null == response) {
      logger.error(String.format("Email not found = %s", username));
      throw new UsernameNotFoundException("Email not found");
    }

    return response;
  }

}
