package com.AssistenteFutebol.Assistente.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SofaScoreService {

    public void buscarJogosAoVivo() {

        String url =
                "https://api.sofascore.com/api/v1/sport/football/events/live";

        try {

            RestTemplate restTemplate =
                    new RestTemplate();

            HttpHeaders headers =
                    new HttpHeaders();

            headers.set(
                    "User-Agent",
                    "Mozilla/5.0"
            );

            headers.set(
                    "Accept",
                    "application/json"
            );

            HttpEntity<String> entity =
                    new HttpEntity<>(headers);

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            entity,
                            String.class
                    );

            log.info(
                    "Resposta da API:"
            );

            log.info(
                    response.getBody()
            );

        } catch (Exception e) {

            log.error(
                    "Erro ao buscar jogos",
                    e
            );
        }
    }
}