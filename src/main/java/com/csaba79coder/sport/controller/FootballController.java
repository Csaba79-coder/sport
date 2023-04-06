package com.csaba79coder.sport.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class FootballController {

    @Value("${spring.sportmonks.apikey}")
    private String apiKey;

    @GetMapping("/football/teams")
    public ResponseEntity<Object> renderAllFootballTeams() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restTemplate.exchange(
                "https://api.sportmonks.com/v3/football/teams",
                HttpMethod.GET,
                entity,
                Object.class
        );
    }
}
