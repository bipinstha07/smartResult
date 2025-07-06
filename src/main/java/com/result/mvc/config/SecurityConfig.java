package com.result.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(e->e.disable());
//        httpSecurity.cors(e->{
//            e.disable();
//        });

        httpSecurity.authorizeHttpRequests(request->
//                request.requestMatchers("/login","/about","/").permitAll()
//                        .anyRequest().authenticated()

                request.requestMatchers("/result/addResult").authenticated()
                        .anyRequest().permitAll()

                ).formLogin(form->form.loginPage("/login").defaultSuccessUrl("/result/addResult")
//                .usernameParameter("username")
                .loginProcessingUrl("/process-login")
                .permitAll()
        ).logout(logout->
                logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
        )

        ;

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetails(){
//        UserDetails user1 = User.builder().username("bipin").password("{noop}bipin123").build();
//        UserDetails user2 = User.builder().username("karina").password("{noop}karina123").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }


}
