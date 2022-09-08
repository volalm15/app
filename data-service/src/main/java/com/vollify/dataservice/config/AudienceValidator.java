package com.vollify.dataservice.config;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 05.09.2022, Mon
 **/

class AudienceValidator
  implements OAuth2TokenValidator<Jwt> {
  private final String audience;

  AudienceValidator(String audience) {
    this.audience = audience;
  }

  public OAuth2TokenValidatorResult validate(Jwt jwt) {
    OAuth2Error error = new OAuth2Error("invalid_token", "The required audience is invalid or missing", null);

    if (jwt.getAudience().contains(audience)) {
      return OAuth2TokenValidatorResult.success();
    }

    return OAuth2TokenValidatorResult.failure(error);
  }
}