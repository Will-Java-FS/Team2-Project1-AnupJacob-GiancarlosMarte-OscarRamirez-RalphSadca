package com.revature.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import java.security.Key;

@Component
public class JwtConverter {

    // Signing key
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // "Configurable" constants
    private final String ISSUER = "Ecommerce";                       // We should come up with a name tbh
    private final int EXPIRATION_MINUTES = 50;
    private final int EXPI
}
