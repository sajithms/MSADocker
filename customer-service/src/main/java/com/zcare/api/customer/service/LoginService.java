package com.zcare.api.customer.service;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.zcare.api.customer.controller.LoginController;
import com.zcare.api.customer.domain.OauthToken;

@Service
public class LoginService {
	@Value("${oauth.client.id}")
	String clientId;
	
	@Value("${oauth.client.secret}")
	String clientSecret;
	
	
	@Value("${oauth.client.granttype}")
	String grantType;
	
	@Value("${oauth.server.url}")
	String oauthUrl;
	
	@Value("${oauth.server.logout_url}")
	String logoutUrl;
	public static final Logger log =  LoggerFactory.getLogger(LoginService.class);

	public OauthToken login(HttpServletRequest request) {

		final String authorization = request.getHeader("Authorization");
		String base64Credentials = authorization.substring("Basic".length()).trim();
		String credentials = new String(Base64.getDecoder().decode(base64Credentials),Charset.forName("UTF-8"));
		final String[] values = credentials.split(":",2);
		log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> credentials::  {}",credentials);

		RestTemplate template = new RestTemplate();
		HttpHeaders headers = createHeaders(clientId,clientSecret);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);



		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("username", values[0]);
		map.add("password", values[1]);
		map.add("grant_type", grantType);

		HttpEntity<MultiValueMap<String, String>> oauthRequest = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<OauthToken> response = null;
		try{
			response = template.postForEntity( oauthUrl, oauthRequest , OauthToken.class );

		} catch(HttpStatusCodeException e){
			log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> HttpStatusCodeException.getRawStatusCode::  {}",e.getRawStatusCode());
			throw new UsernameNotFoundException(e.getResponseBodyAsString());

		} catch(RestClientException e){
			throw new UsernameNotFoundException(e.getMessage());
		}


		return response.getBody();




	}
	
	public Object logout(HttpServletRequest request) {

		
		 String authorization = request.getHeader("Authorization");
		 
		 log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> authorization::  {}",authorization);
		 
	        if (authorization != null && authorization.contains("Bearer")) {
	            String tokenId = authorization.substring("Bearer".length() + 1);
	           // log.info("******************&&&&&&&&&&&&&&&&------>>>>>>>>>>>>>>>>> accessToken.getRefreshToken() ::  {}",tokenId);
	            
	            RestTemplate template = new RestTemplate();
	    		//HttpHeaders headers = createHeaders(clientId,clientSecret);
	            HttpHeaders headers = new HttpHeaders();
	    		//headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    		
	    		
	    		
	    		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	    		
	    		
	    		HttpEntity<MultiValueMap<String, String>> oauthRequest = new HttpEntity<MultiValueMap<String, String>>(map, headers);

	    		ResponseEntity<Object> response = template.postForEntity( logoutUrl+tokenId, oauthRequest , Object.class );
	    		
	    		return response.getBody();
	           
	        }
	        
	
		return null;
	}
	
	
	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}

}
