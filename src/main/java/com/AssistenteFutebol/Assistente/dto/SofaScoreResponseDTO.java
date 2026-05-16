package com.AssistenteFutebol.Assistente.dto;

import lombok.Data;

import java.util.List;

@Data
public class SofaScoreResponseDTO {

    private List<EventDTO> events;
}