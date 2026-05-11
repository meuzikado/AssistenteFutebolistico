package com.AssistenteFutebol.Assistente.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "partidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mandante_id")
    private Time mandante;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Time visitante;

    private LocalDate data;

    private Integer golsMandanteHT;

    private Integer golsVisitanteHT;

    private Integer escanteiosMandanteHT;

    private Integer escanteiosVisitanteHT;

    private Integer golsAntes30Mandante;

    private Integer golsAntes30Visitante;

    private Integer escanteios15Mandante;

    private Integer escanteios15Visitante;
}