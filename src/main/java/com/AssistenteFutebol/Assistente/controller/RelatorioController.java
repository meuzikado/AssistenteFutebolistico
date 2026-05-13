package com.AssistenteFutebol.Assistente.controller;

import com.AssistenteFutebol.Assistente.dto.AnaliseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @GetMapping("/dia")
    public List<AnaliseDTO> relatorioDoDia() {

        return List.of();
    }
}
