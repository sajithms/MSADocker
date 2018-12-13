package com.zcare.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.zcare.api.security.CustomUserDetailsService;
import com.zcare.api.security.encoder.CustomPasswordEncoder;


@Configuration
@EnableWebSecurity//(debug=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   

    @Bean
    public UserDetailsService userDetailsService() {
      return new CustomUserDetailsService();
    };
    
    
    @Bean
    public CustomPasswordEncoder customPasswordEncoder() {
      return new CustomPasswordEncoder();
    };
    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
    */
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
       
        authProvider.setPasswordEncoder(new CustomPasswordEncoder());
        return authProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        //auth.authenticationProvider(authProvider());
    	 auth.userDetailsService(userDetailsService()).passwordEncoder(customPasswordEncoder());
    }
    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
    	
    	 auth.authenticationProvider(authProvider());
    }
    */
    
   
    @Bean
    public static CustomPasswordEncoder passwordEncoder() {
    return new CustomPasswordEncoder();
    }
    

   

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/login").permitAll()
    	.antMatchers("/v1/login").permitAll()
		.antMatchers("/webjars/**").permitAll() 
		.antMatchers("/swagger-ui.html","/swagger-resources/**", "/v2/api-docs/**").permitAll()
		.antMatchers("/actuator","/actuator/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().csrf().disable();
    }

}

