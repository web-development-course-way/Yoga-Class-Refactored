package com.horus.yoga.util;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloakSecurityUtil {

    Keycloak keycloak;

    @Value("${keycloak.server-url}")
    private String serverUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.grant-type}")
    private String grantType;

    @Value("${keycloak.name}")
    private String username;

    @Value("${keycloak.password}")
    private String password;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public Keycloak getKeycloakInstance() {
        if(keycloak == null) {
            keycloak = KeycloakBuilder
                    .builder().serverUrl(serverUrl).realm(realm)
                    .clientId(clientId).grantType(grantType)
                    .username(username).password(password).clientSecret(clientSecret).build();
            System.out.println("i was here");
        }
        return keycloak;
    }
}
