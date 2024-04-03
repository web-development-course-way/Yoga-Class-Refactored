package com.horus.yoga.config;


import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional getCurrentAuditor() {
        // Placeholder till we implement Spring Security which will get for us the userName
        return Optional.of("Test User");
    }

}
