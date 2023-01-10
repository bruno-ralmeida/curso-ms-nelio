package br.com.xxnbr.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xxnbr.hroauth.entities.User;
import br.com.xxnbr.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

  private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

  @Autowired(required = true)
  private UserFeignClient feignClient;

  public User findByEmail(String email) {
    var response = feignClient.findByEmail(email).getBody();

    if (null == response) {
      logger.error(String.format("Email not found = %s", email));
      throw new IllegalArgumentException("Email not found");
    }

    return response;
  }

}
