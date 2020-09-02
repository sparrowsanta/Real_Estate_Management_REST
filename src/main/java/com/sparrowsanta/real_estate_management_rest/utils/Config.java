package com.sparrowsanta.real_estate_management_rest.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy

public class Config {

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getFlatConverter());
    }

    @Bean
    public FlatConverter getFlatConverter() {
        return new FlatConverter();
    }

}
