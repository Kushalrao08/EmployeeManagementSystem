package com.Spring.EmployeeManagementSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
	 @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public InMemoryUserDetailsManager userDetailsManager(){

	        UserDetails admin=User.builder()
	                .username("admin")
	                .password(passwordEncoder().encode("admin123"))
	                .roles("ADMIN")
	                .build();

	        UserDetails user=User.builder()
	                .username("user")
	                .password(passwordEncoder().encode("user123"))
	                .roles("USER")
	                .build();
	        return new InMemoryUserDetailsManager(admin,user);

	    }
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
	    http
        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth

            .requestMatchers(HttpMethod.GET,
                    "/employees/fetch",
                    "/employees/fetch/**")
            .hasAnyRole("USER", "ADMIN")

            .requestMatchers(HttpMethod.POST,
                    "/employees/add")
            .hasRole("ADMIN")

            .requestMatchers(HttpMethod.PUT,
                    "/employees/update/**")
            .hasRole("ADMIN")

            .requestMatchers(HttpMethod.DELETE,
                    "/employees/delete/**")
            .hasRole("ADMIN")
            .anyRequest()
            .authenticated()
        )
        .httpBasic(Customizer.withDefaults());
    return http.build();
	    }

}
