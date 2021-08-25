package io.github.somesh.springhateos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConsumer {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public String getSampleApi(int id){
        String response = restTemplate.getForObject("http://numbersapi.com/{id}",String.class,id);
        return response;
    }

}
