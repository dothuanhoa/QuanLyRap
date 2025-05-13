// package com.QuanLyRap.config;

// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.context.annotation.Bean;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http
// .authorizeHttpRequests(authz -> authz
// .requestMatchers("/", "/about-us", "/login", "/movie", "/pick-chair",
// "/product", "/registered",
// "/registered/save")
// .permitAll()
// .anyRequest().authenticated())
// .formLogin(login -> login
// .loginPage("/login")
// .permitAll())
// .logout(logout -> logout
// .logoutSuccessUrl("/")
// .permitAll());

// return http.build();
// }
// }
