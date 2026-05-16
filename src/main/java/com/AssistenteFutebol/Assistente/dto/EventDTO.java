package com.AssistenteFutebol.Assistente.dto;

import lombok.Data;

@Data
public class EventDTO {

    private TeamDTO homeTeam;

    private TeamDTO awayTeam;
}