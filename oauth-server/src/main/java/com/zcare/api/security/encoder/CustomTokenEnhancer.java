package com.zcare.api.security.encoder;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.zcare.api.domain.UserContext;



public class CustomTokenEnhancer implements TokenEnhancer {
	private final Logger log = LoggerFactory.getLogger(CustomTokenEnhancer.class);
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //User user = (User) authentication.getPrincipal();
    	log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> accessToken.getRefreshToken() ::  {}",accessToken.getRefreshToken());
        final Map<String, Object> additionalInfo = new HashMap<>();
		if(UserContext.getCurrentUser() != null){
			log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> UserContext.getCurrentUseris not null ::  {}",UserContext.getCurrentUser());
			 com.zcare.api.domain.User currentUser = (com.zcare.api.domain.User) UserContext.getCurrentUser();
			 if(currentUser != null){
				 log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> currentUser is not null  ::  {}",UserContext.getCurrentUser());
				 additionalInfo.put("user_id", currentUser.getUserId());
				additionalInfo.put("user_name", currentUser.getUsername());
				additionalInfo.put("number_of_failedlogins", currentUser.getNumberOfFailedLogins());
			 }
			
		}
       

        log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> additionalInfo ::  {}",additionalInfo);
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }

}
