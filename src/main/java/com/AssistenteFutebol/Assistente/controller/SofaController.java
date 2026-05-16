package com.AssistenteFutebol.Assistente.controller;

import com.AssistenteFutebol.Assistente.service.SofaScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SofaController {

    private final SofaScoreService sofaScoreService;

    @GetMapping("/sofa")
    public String buscarJogos() {

        sofaScoreService.buscarJogosAoVivo();

        return "Jogos carregados!";
    }
}