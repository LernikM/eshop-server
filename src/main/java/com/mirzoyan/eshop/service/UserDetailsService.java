package com.mirzoyan.eshop.service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsService {

    /**
     * return user full name by keycloak.
     *
     * @return String User Full Name
     */
    public String getUserId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(Authentication::getDetails)
            .map(SimpleKeycloakAccount.class::cast)
            .map(SimpleKeycloakAccount::getKeycloakSecurityContext)
            .map(RefreshableKeycloakSecurityContext::getToken)
            .map(IDToken::getId)
            .orElse(null);
    }

    public String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
