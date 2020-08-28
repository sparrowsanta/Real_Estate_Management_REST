package com.sparrowsanta.real_estate_management_rest.utils;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy

public class Config {


}
