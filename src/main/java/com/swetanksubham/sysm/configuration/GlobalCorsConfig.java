package com.swetanksubham.sysm.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.NonNull;

import java.util.List;

@Configuration
public class GlobalCorsConfig {
    
    @Value("${allowed.origins:http://localhost:3000}")
    private String allowedOrigins;

    @Bean
    CorsFilter corsFilter() {
        @NonNull
        final CorsConfiguration config = new CorsConfiguration();

        @NonNull
        final List<String> origins = List.of(allowedOrigins.split(","));

        config.setAllowedOrigins(origins);
        config.setAllowedMethods(List.of(
            "GET",
            "POST",
            "PUT",
            "DELETE",
            "OPTIONS"));

        config.setAllowedHeaders(List.of(
            "Authorization",
            "Cache-Control",
            "Content-Type"));

        @NonNull
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);  // Applies to all endpoints
        return new CorsFilter(source);
    }

}
