package com.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/v1/producer/wikimedia/")
@Slf4j
public class ProducerWikimediaController {

    private final WebClient webClient;

    public ProducerWikimediaController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
    }

    @GetMapping("get-real-changes")
    public String getRealChanges(){
        log.info("******************* getRealChanges ***************");

        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(log::info);
        return "With webclient";
    }
}
