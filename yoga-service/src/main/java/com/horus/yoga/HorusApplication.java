package com.horus.yoga;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(
		name = "Keycloak"
		, openIdConnectUrl = "http://localhost:8081/realms/spring/.well-known/openid-configuration"
		, scheme = "bearer"
		, type = SecuritySchemeType.OPENIDCONNECT
		, in = SecuritySchemeIn.HEADER
)

public class HorusApplication {

	private static final Log logger = LogFactory.getLog(HorusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HorusApplication.class, args);
	}

}
