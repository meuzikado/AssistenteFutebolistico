package com.AssistenteFutebol.Assistente.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnaliseDTO {

    private String confronto;

    private Double probabilidadeOverHT;

    private Double mediaEscanteiosHT;

    private Double mediaRaceEscanteios;

    private Boolean tendenciaCantos;

    private Boolean padraoPressao;
}
