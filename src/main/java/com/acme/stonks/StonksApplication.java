package com.acme.stonks;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class StonksApplication {

    public static void main(String[] args) {

        SpringApplication.run(StonksApplication.class, args); }


        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }



    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins( "*" )
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }



}
