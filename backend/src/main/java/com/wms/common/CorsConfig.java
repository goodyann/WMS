package com.wms.common;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        //if send Cookie or not
        .allowCredentials(true)
        //allow which original patterns
        .allowedOriginPatterns("*")
        .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
        .allowedHeaders("*")
        .exposedHeaders("*");
    }
}