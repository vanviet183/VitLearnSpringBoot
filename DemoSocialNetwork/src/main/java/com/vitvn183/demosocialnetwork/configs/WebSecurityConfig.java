//package com.vitvn183.demosocialnetwork.configs;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig {
//
////    @Bean
////    @Override
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder () {
//        return new BCryptPasswordEncoder(11);
//    }
//
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().configurationSource(request -> corsConfiguration())
////                .and().csrf().disable()
////                .authorizeRequests()
//////                .antMatchers(USER_LIST_URLS).permitAll()
//////                .antMatchers(ADMIN_LIST_URLS).hasAnyAuthority("ROLE_ADMIN")
////                .antMatchers("/**").permitAll()
//////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                    .loginPage("/login")
////                    .usernameParameter("email")
////                    .permitAll()
////                    .defaultSuccessUrl("/")
////                .and()
////
////                .oauth2Login()
////                .loginPage("/login")
////                .userInfoEndpoint()
////                .and()
////                .and()
//////                .userService(oAuth2UserService);
//////                .successHandler(oAuth2LoginSuccessHandler)
//////                .and()
//////                .and()
////                .logout().permitAll()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////
////    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeRequests()
////                .antMatchers(USER_LIST_URLS).permitAll()
////                .antMatchers(ADMIN_LIST_URLS).hasAnyAuthority("ROLE_ADMIN")
//                .antMatchers("/**").permitAll()
////                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .permitAll()
//                .defaultSuccessUrl("/")
//                .and()
//
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .and()
//                .and()
////                .userService(oAuth2UserService);
////                .successHandler(oAuth2LoginSuccessHandler)
////                .and()
////                .and()
//                .logout().permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        return http.build();
//    }
//
//
//    CorsConfiguration corsConfiguration() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.applyPermitDefaultValues();
//        corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
//        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
//        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
//        return corsConfiguration;
//    }
//
//
//}
