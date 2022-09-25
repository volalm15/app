package com.vollify.dataservice.config;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtGrantedAuthoritiesConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 20.09.2022, Tue
 **/

@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

    return http.authorizeExchange(
        exchanges -> exchanges.pathMatchers("/books").hasRole("moderator").anyExchange().authenticated())
      .oauth2ResourceServer(
        oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverterForKeycloak())))
      .build();
  }

  /**
   * By default, Keycloak assigns user roles to a "roles" object within the "realm_access" claim.
   * This converter extracts the list of user roles from "realm.access.roles" and builds
   * a list of GrantedAuthority using the "ROLE_" prefix.
   */
  private ReactiveJwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
    Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
      Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
      Collection<String> roles = realmAccess.get("roles");
      return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
        .collect(Collectors.toList());
    };

    var jwtAuthenticationConverter = new ReactiveJwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(
      new ReactiveJwtGrantedAuthoritiesConverterAdapter(jwtGrantedAuthoritiesConverter));

    return jwtAuthenticationConverter;
  }
}
