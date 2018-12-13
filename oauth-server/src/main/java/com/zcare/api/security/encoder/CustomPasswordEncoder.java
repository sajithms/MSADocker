package com.zcare.api.security.encoder;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
	
	private final Logger log = LoggerFactory.getLogger(CustomPasswordEncoder.class);
    @Override
    public String encode(CharSequence rawPassword) {
       
       //return "$2a$10$AR8CkWqlULhQ3Iqog6jAGudfr6t.4ksWDV5Kzc4Cpxt.dTdjbkAni";//
    	//log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> calling  encode ::  {}",rawPassword);
    	return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
    }
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
    	
      // return true;//
    	//log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> calling  matches ::  {}",rawPassword+":: "+encodedPassword);
    	//log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> calling  resullt ::  {}",BCrypt.checkpw(rawPassword.toString(), encodedPassword));
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
