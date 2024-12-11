package com.example.mady.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class RestConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false); // Установите false, если хотите использовать "*" для всех доменов
        config.addAllowedOriginPattern("*"); // Разрешить доступ всем доменам
        config.addAllowedHeader("*"); // Разрешить любые заголовки
        config.addAllowedMethod("*"); // Разрешить любые HTTP-методы (GET, POST, PUT, DELETE и т.д.)
        source.registerCorsConfiguration("/**", config); // Применить CORS ко всем маршрутам
        return new CorsFilter(source);
    }
}