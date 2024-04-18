package com.horus.yoga.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
public class KeyCloakService {

//    private final RestTemplate restTemplate;
//    private final String baseURL = "http://localhost:8081/realms/Yoga-class-application/";

//    KeyCloakService() {
//        this.restTemplate = new RestTemplate().execute(baseURL + "/protocol/openid-connect/token", HttpMethod.POST);
//    }


//    @Bean
////    @Profile("!test")
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        returnargs -> {
//            Quote quote = restTemplate.getForObject(
//                    "http://localhost:8080/api/random", Quote.class);
//            log.info(quote.toString());
//        };
//    }
}
