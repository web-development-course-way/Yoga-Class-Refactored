package com.yoga.horus.config;


import com.yoga.horus.dtoMapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserMapper getUserMapper(){
        return Mappers.getMapper(UserMapper.class);
    }
}
