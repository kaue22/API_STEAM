package com.estudo.steam.service;

import com.estudo.steam.model.SteamModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.HashMap;
import java.util.Map;
@Service
public class SteamAppService {


    @Value("${STEAM_API}")
    private String steamapp;

    @Value("${URL_STEAM}")
    private String steamUrl;


    public void getSteamId(){


        String json = "json";
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        restTemplate=restTemplateBuilder.build();


        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> params = new HashMap<String, String>();
       /* params.put("msisdn", msisdn);
        params.put("msisdn", msisdn);*/
        params.put("format",json);


        String urlSteamTemplate = UriComponentsBuilder.fromHttpUrl(steamUrl)
                .queryParam("format", json)
                .toUriString();

        System.out.println(urlSteamTemplate);

        HttpEntity entity = new HttpEntity(headers);


        HttpEntity<String> response = restTemplate.exchange(urlSteamTemplate, HttpMethod.GET, entity, String.class, params);


    }
}
