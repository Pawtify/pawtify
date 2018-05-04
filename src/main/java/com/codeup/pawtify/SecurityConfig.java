package com.codeup.pawtify;

import com.codeup.pawtify.services.UserDetailsLoader;
import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsLoader usersLoader;

    public SecurityConfig(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords
        ;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration for pa*/
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/pawtification/")// user's home page, it can be any URL
                    .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/pets", "/animal/{id}", "/login", "/register/adopter")
                    .permitAll()
                /* Pages that require athentication */
                .and()
                    .authorizeRequests()
                    .antMatchers("/animals/create", "/animals/{id}/edit")
                    .hasAuthority("rolestaff")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/pawtification/")
//                .hasAuthority("roleadopter")

        ;



    }
}
