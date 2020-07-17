package dev.sukanya.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration  //Says that this class is a Configuration class where we define our configs --> Here we do password encryption
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encode(){

        return new BCryptPasswordEncoder(12);
        //Spring is a application context where there are loads of objects called Beans.
        // Using this bean, we can autowire Password encoder anywhere in the application
    }

}
