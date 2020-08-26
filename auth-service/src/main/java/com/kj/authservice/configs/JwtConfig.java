package com.kj.authservice.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtConfig {
//    @Value(value = "${security.jwt.uri:/auth/**}")
    private String uri = "/auth/**";

//    @Value(value = "${security.jwt.header:Authorization}")
    private String header = "Authorization";

//    @Value(value = "${security.jwt.prefix:Bearer }")
    private String prefix = "Bearer ";

//    @Value(value = "${security.jwt.expiration:#{24*60*60}}")
    private int expiration = 24 * 60 * 60;

//    @Value(value = "${security.jwt.secret:JwtSecretKey}")
    private String secret = "JwtSecretKey";
}
