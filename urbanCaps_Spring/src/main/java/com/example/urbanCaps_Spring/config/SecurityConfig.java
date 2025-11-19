package com.example.urbanCaps_Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Definiciom de los usuarios y roles en memoria
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){

        //Se define un usuario simple para acceder a al API
        UserDetails admin = User.withUsername("user")
                .password(encoder.encode("pass"))
                .roles("ADMIN")
                .build();

        UserDetails invitado = User.withUsername("invitado")
                .password(encoder.encode("invitado"))
                        .roles("INVITADO")
                        .build();
        return new InMemoryUserDetailsManager(admin, invitado);
    }
    //Se define el codificador de contraseña
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //Se define la rela de autoriacion
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
                .csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/ventas/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/ventas/**").hasAnyRole("ADMIN", "INVITADO")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {});
        return http.build();
    }
}
