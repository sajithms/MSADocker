package com.zcare.api.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zcare.api.domain.User;
import com.zcare.api.domain.UserContext;
import com.zcare.api.repository.UserRepository;


@Component("userDetailsService")
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserDetails loadUserByUsername(final String login) {

    	log.info("******************------>>>>>>>>>>>>>>>>> loadUserByUsername ::  {}",login);
        log.info("******************------>>>>>>>>>>>>>>>>> Authenticating {}", login);
       

        User userFromDatabase;
     
            userFromDatabase = userRepository.findByUsername(login);
        
            log.info("******************------>>>>>>>>>>>>>>>>> Authenticating {}", userFromDatabase);
       

        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        } else if (!userFromDatabase.isActivated()) {
            throw new UserNotActivatedException("User " + login + " is not activated");
        }

        log.info("******************------>>>>>>>>>>>>>>>>> userFromDatabase {}", userFromDatabase);
        
        
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        /*
        for (Authority authority : userFromDatabase.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        */
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);
        UserContext.setCurrentUser(userFromDatabase);
        return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(), userFromDatabase.getPassword(), grantedAuthorities);

    }

}
