package com.AssistenteFutebol.Assistente.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScrapingService {

    public void atualizarJogos() {

        try {

            Document document = Jsoup.connect(
                    "https://www.sofascore.com"
            ).get();

            log.info("Conectado ao SofaScore");

            // EXTRAÇÃO FUTURA:
            // posse
            // chutes
            // escanteios
            // gols HT
            // pressão inicial

        } catch (Exception e) {

            log.error(
                    "Erro no scraping",
                    e
            );
        }
    }
}
