package com.example.app.services;


import com.example.app.entity.CambioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Service
public class CambioDataService {
    @Autowired
    WebClient webClient;


    public Mono<Float> getExchangeRate(String origin, String destination) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest")
                        .queryParam("from", origin)
                        .queryParam("to", destination)
                        .build())
                .retrieve()
                .bodyToMono(CambioData.class)
                .map(data -> data.getRates().get(destination))
                .timeout(Duration.ofMillis(10_000));
    }
}

