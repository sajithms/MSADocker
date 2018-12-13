package com.zcare.api.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TokenController {
	private final Logger log = LoggerFactory.getLogger(TokenController.class);
    
	 @Autowired
	 private DataSource dataSource;
	 

    ConsumerTokenServices tokenServices;

 
    TokenStore tokenStore;
    
    
   
    
    

    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token/revokeById/{tokenId}")
    @ResponseBody
    public void revokeToken(HttpServletRequest request, @PathVariable String tokenId) {
    	
    	log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> /oauth/token/revokeById/{tokenId} ::  {}",tokenId);
    	if(tokenServices == null) {
    		
    		log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> Toke service null ::  {}",tokenId);
    		 DefaultTokenServices defaulttokenServices = new DefaultTokenServices();
    		 defaulttokenServices.setTokenStore( new JdbcTokenStore(dataSource));
    		 tokenServices = defaulttokenServices;
    	       
    	}
    	
        tokenServices.revokeToken(tokenId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tokens")
    @ResponseBody
    public List<String> getTokens(HttpServletRequest request) {
        List<String> tokenValues = new ArrayList<String>();
        if(tokenStore ==null) {
    		tokenStore = new JdbcTokenStore(dataSource);
    	}
        final String authorization = request.getHeader("Authorization");
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),Charset.forName("UTF-8"));
        final String[] values = credentials.split(":",2);
        
        Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId(values[0]);
        if (tokens != null) {
            for (OAuth2AccessToken token : tokens) {
                tokenValues.add(token.getValue());
            }
        }
        return tokenValues;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tokens/revokeRefreshToken/{tokenId:.*}")
    @ResponseBody
    public String revokeRefreshToken(@PathVariable String tokenId) {
    	if(tokenStore ==null) {
    		tokenStore = new JdbcTokenStore(dataSource);
    	}
        if (tokenStore instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenStore).removeRefreshToken(tokenId);
        }
        return tokenId;
    }

}