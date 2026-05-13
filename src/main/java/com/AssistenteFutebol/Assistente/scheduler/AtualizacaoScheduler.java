package com.AssistenteFutebol.Assistente.scheduler;

import com.AssistenteFutebol.Assistente.service.ScrapingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AtualizacaoScheduler {

    private final ScrapingService scrapingService;

    @Scheduled(cron = "0 0 04 * * *")
    public void atualizarDados() {

        log.info(
                "Iniciando atualização diária..."
        );

        scrapingService.atualizarJogos();

        log.info(
                "Atualização concluída."
        );
    }
}