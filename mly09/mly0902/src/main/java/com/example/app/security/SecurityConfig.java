package com.example.app.security;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration)
            throws Exception {return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers(
                headersConfigurer -> headersConfigurer
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/movimiento/","/movimiento/list/**","/cuenta","/cuenta/list/**","/home","/","/index").permitAll()
                        .requestMatchers("/usuario/**").hasRole("ADMIN")
                        .requestMatchers("/movimiento/**").hasRole("USER")
                        .requestMatchers("/movimiento/**","/cuenta/**").hasAnyRole("ADMIN","TITULAR")
                        .requestMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations()))
                        .permitAll() // para rutas: /css, /js /images
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/index", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/index")
                        .permitAll())
//.csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults());
        http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/accessError"));
        return http.build();
    }
}