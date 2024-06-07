package com.boombastic.mediateca.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// ... other imports

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(auth -> auth  // Lambda approach for authorization rules
                        .requestMatchers("/login", "/register", "/usuarios", "/css/**", "/js/**")
                        .permitAll() // Allow any authenticated or unauthenticated user for these URLs
                        .anyRequest() // Apply security to all other requests
                        .authenticated()) // Require authentication for all other requests
                .formLogin(form -> form  // Lambda approach for form login configuration
                        .loginPage("/login") // Login page URL
                        .defaultSuccessUrl("/usuarios") // Redirect after successful login
                        .loginProcessingUrl("/login") // Login form processing URL
                        .failureUrl("/login?error=true")) // URL on login failure
                .logout(logout -> logout  // Lambda approach for logout configuration
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Logout URL
                        .permitAll()); // Allow anyone to access the logout URL

        return http.build();
    }

    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
