package io.github.somesh.springhateos.app;

import io.github.somesh.springhateos.config.JWT;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class OAuthApiConsumer {

    @Autowired
    private RestTemplate restTemplate;

    public String getOauthResponse(){
        ResponseEntity<JWT> jwt = restTemplate.exchange("http://localhost:8080/oauth/token?grant_type=client_credentials&scope=info", HttpMethod.POST,new HttpEntity(createHeaders("client", "secret")), JWT.class);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization",jwt.getBody().getTokenType()+" "+jwt.getBody().getAccesToken());
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/hello",HttpMethod.GET,new HttpEntity<>(headers),String.class);
        return response.getBody();
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}
