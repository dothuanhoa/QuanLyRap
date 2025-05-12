// package com.QuanLyRap.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http.csrf().disable()
// .authorizeRequests()
// .antMatchers("/admin/**").hasRole("ADMIN") // Chỉ admin được phép truy cập
// .antMatchers("/**").permitAll() // Tất cả người dùng được phép truy cập các
// trang khác
// .and()
// .formLogin()
// .loginPage("/login") // Trang đăng nhập
// .defaultSuccessUrl("/", true) // Trang mặc định sau khi đăng nhập thành công
// .permitAll() // Cho phép tất cả người dùng truy cập trang đăng nhập
// .and()
// .logout()
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login") // Trang sau khi đăng xuất
// .permitAll(); // Cho phép tất cả người dùng truy cập trang đăng xuất
// return http.build();
// }
// }
