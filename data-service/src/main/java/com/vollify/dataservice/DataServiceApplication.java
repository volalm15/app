package com.vollify.dataservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtGrantedAuthoritiesConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class DataServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DataServiceApplication.class, args);
  }

  record Book(String title) {
  }

  @Data
  @RestController
  @Slf4j
  static class BookController {

    @GetMapping("books")
    public Flux<Book> getBooks(@AuthenticationPrincipal JwtAuthenticationToken jwtToken) {
      log.info("Books browsed by " + jwtToken.getTokenAttributes().get("given_name"));
      return Flux.just(
        new Book("Harry Potter"),
        new Book("His Dark Materials"),
        new Book("The Hobbit"),
        new Book("The Lord of the Rings"),
        new Book("The Chronicles of Narnia"),
        new Book("The Silmarillion"),
        new Book("The Hitchhiker's Guide to the Galaxy")
      );
    }

    @GetMapping("/whoami")
    @ResponseBody
    public Map<String, Object> index(
      @AuthenticationPrincipal(errorOnInvalidType = true) Jwt user) {
      Map<String, Object> model = new HashMap<>();
      model.put("userName", user);
      return model;
    }
  }



}
