////package com.exam.springbootbackend.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
////import org.springframework.security.web.SecurityFilterChain;
////
////import static org.springframework.security.config.Customizer.withDefaults;
////
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests(authorizeRequests -> authorizeRequests
////                        .requestMatchers("/api/auth/register").permitAll()
////                        .requestMatchers("/api/auth/login").permitAll()
////                        .requestMatchers("/api/v1/**").authenticated()
////                )
////                .httpBasic(withDefaults()); // This disables form-based login
////
////        return http.build();
////    }
////}
//package com.exam.springbootbackend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/api/auth/register").permitAll() // Allow registration endpoint
//                                .requestMatchers("/api/auth/login").permitAll()    // Allow login endpoint
//                                .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults()); // Enable form-based login
//
//        return http.build();
//    }
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("register")
////                .password("password")
////                .roles("USER")
////                .username("admin")
////                .password("passworda")
////                .roles("ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(user);
////    }
//}
