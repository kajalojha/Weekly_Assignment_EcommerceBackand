package com.TaskManagementSystem.TaskManagement.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import javax.management.relation.Role;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableMethodSecurity
 @EnableWebSecurity
public class SecurityConfig {
    // for encrypt password
    @Bean
    public PasswordEncoder passwordEncoder(){
    return  new BCryptPasswordEncoder();
    }

    //UserDetailsService is a inbuilt inteface of springboot that is usd to create user and admin with their details and roles
    // In memory method
    @Bean
    public UserDetailsService userDetailsService(){

        //create users
        UserDetails normaluser = User
                .withUsername("kajal")
                //.password("kajal")// simple pass but we encrypt this
                .password(passwordEncoder().encode("kajal"))
     //password($2a$12$gsFd0aRmGYORms.Vey3t9.UgZi7W/Si2Y3/hX2i8OJ6Zvz/ETbwKi)
                .roles("user")
                .build();


       // create admin
        UserDetails admin = User
                .withUsername("admin")
               // .password("admin" )
                .password(passwordEncoder().encode("admin "))
                //.password($2a$12$0MTUSYnEsrY0AKzcje02bOuPq5iJtQ2tc7CNohshkb8VCFuQRVGvq)
                .roles("admin")
                .build();

         // it is a subclass or implementation class of userDetailsService
        //InMemoryUserDetailsManager() class springboot that is used to manage userdetails and admin both
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normaluser , admin);
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normaluser );
       return inMemoryUserDetailsManager;

        // THROUGH DATABASE

         //public class CustomUserDetaiService

  }
//    @Bean
//    public UserDetailsService userDetailsService (){
//        UserDetails normalUser = User.builder()
//                .username("kajal")
//                .password(passwordEncoder().encode("kajal")) // Encode the password
//                //.password("$2a$12$gsFd0aRmGYORms.Vey3t9.UgZi7W/Si2Y3/hX2i8OJ6Zvz/ETbwKi")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                //.password("admin")
//                .password(passwordEncoder().encode("admin")) // Encode the password
//               // .password("$2a$12$0MTUSYnEsrY0AKzcje02bOuPq5iJtQ2tc7CNohshkb8VCFuQRVGvq")
//                .roles("ADMIN" )
//                .build();
//        return new InMemoryUserDetailsManager(normalUser , admin);
//
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrfSpec -> csrfSpec.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                                //  .requestMatchers("/**")
////                        .requestMatchers("/admin") // we  have also other method to doing this
////                        .hasRole("admin") //set the role with method useing @PreAuhorize annotation
////                        .requestMatchers("/normal")
////                        .hasRole("normal")
////                                .requestMatchers("/admin/**").hasRole("ADMIN")
////                                .requestMatchers("/user/**").hasRole("USER")
//                                .requestMatchers("/public")
//                                .permitAll()
//                                .anyRequest()
//                                .authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        //http.addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
//        return http.build();
//
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfSpec -> csrfSpec.disable())
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/public")
                                 .permitAll()
//                                .requestMatchers("/adminUser/**").hasRole("ADMIN")
//                                .requestMatchers("/normaluser/**").hasRole("USER")
                                .anyRequest()
                                .authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        //http.addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
        return http.build();

    }


}

