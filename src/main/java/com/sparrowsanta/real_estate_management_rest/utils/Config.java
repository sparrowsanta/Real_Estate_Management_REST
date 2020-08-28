package com.sparrowsanta.real_estate_management_rest.utils;


import org.javers.core.Javers;
import org.javers.spring.JaversAuditable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@JaversAuditable
public class Config {


}
