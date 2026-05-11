package com.AssistenteFutebol.Assistente.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estatisticas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estatistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    private Integer posseMandante;

    private Integer posseVisitante;

    private Integer chutesMandante;

    private Integer chutesVisitante;

    private Integer escanteiosMandante;

    private Integer escanteiosVisitante;
}
