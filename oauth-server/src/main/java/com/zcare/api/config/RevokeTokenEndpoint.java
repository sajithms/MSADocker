package com.zcare.api.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

	private final Logger log = LoggerFactory.getLogger(RevokeTokenEndpoint.class);
    @Resource(name = "tokenServices")
    ConsumerTokenServices tokenServices;

    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
    	/*
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> accessToken.getRefreshToken() ::  {}",tokenId);
            tokenServices.revokeToken(tokenId);
        }
        */
    	 String tokenId = request.getHeader("Token");
    	 //log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> accessToken.getRefreshToken() ::  {}",tokenId);
    	 tokenServices.revokeToken(tokenId);
    }

}