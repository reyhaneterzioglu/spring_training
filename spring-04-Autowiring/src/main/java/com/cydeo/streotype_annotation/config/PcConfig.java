package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("com.cydeo.streotype_annotation")
public class PcConfig {

    @Bean
    public Integer integer(){
        return 2;
    }

}
