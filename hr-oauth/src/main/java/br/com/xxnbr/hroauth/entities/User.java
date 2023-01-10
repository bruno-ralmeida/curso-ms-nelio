package br.com.xxnbr.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

  private Long id;

  private String name;

  private String email;

  private String password;

  @Setter(AccessLevel.NONE)
  @Builder.Default
  private Set<Role> roles = new HashSet<>();

}
