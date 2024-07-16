package com.basicpractice.basic.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicpractice.basic.DB;
import com.basicpractice.basic.DevDB;
import com.basicpractice.basic.ProdDB;

@Configuration
public class AppConfiguration {

    // @Bean
    // @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    // public DB getDBBean() {
    // return new DevDB();
    // }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getDBBean() {
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
