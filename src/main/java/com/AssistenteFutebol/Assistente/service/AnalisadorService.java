package com.AssistenteFutebol.Assistente.service;

import com.AssistenteFutebol.Assistente.dto.AnaliseDTO;
import com.AssistenteFutebol.Assistente.entity.Partida;
import com.AssistenteFutebol.Assistente.entity.Time;
import com.AssistenteFutebol.Assistente.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalisadorService {

    private final PartidaRepository partidaRepository;

    public AnaliseDTO analisar(
            Time mandante,
            Time visitante
    ) {

        List<Partida> jogosMandante =
                partidaRepository.buscarUltimosJogos(
                        mandante.getId()
                );

        List<Partida> jogosVisitante =
                partidaRepository.buscarUltimosJogos(
                        visitante.getId()
                );

        double overHT =
                calcularOverHT(
                        jogosMandante,
                        jogosVisitante
                );

        double mediaEscanteios =
                calcularEscanteiosHT(
                        jogosMandante,
                        jogosVisitante
                );

        double mediaRace =
                calcularRaceEscanteios(
                        jogosMandante,
                        jogosVisitante
                );

        boolean pressao =
                identificarPressaoAlta(jogosMandante);

        boolean tendencia =
                mediaEscanteios > 4.5;

        return AnaliseDTO.builder()
                .confronto(
                        mandante.getNome()
                        + " x "
                        + visitante.getNome()
                )
                .probabilidadeOverHT(overHT)
                .mediaEscanteiosHT(mediaEscanteios)
                .mediaRaceEscanteios(mediaRace)
                .padraoPressao(pressao)
                .tendenciaCantos(tendencia)
                .build();
    }

    private double calcularOverHT(
            List<Partida> mandante,
            List<Partida> visitante
    ) {

        int gols = 0;
        int jogos = 0;

        for (Partida partida : mandante.stream().limit(10).toList()) {

            gols += partida.getGolsMandanteHT();
            gols += partida.getGolsVisitanteHT();

            jogos++;
        }

        for (Partida partida : visitante.stream().limit(10).toList()) {

            gols += partida.getGolsMandanteHT();
            gols += partida.getGolsVisitanteHT();

            jogos++;
        }

        return (double) gols / jogos;
    }

    private double calcularEscanteiosHT(
            List<Partida> mandante,
            List<Partida> visitante
    ) {

        int escanteios = 0;
        int jogos = 0;

        for (Partida partida : mandante.stream().limit(10).toList()) {

            escanteios += partida.getEscanteiosMandanteHT();
            escanteios += partida.getEscanteiosVisitanteHT();

            jogos++;
        }

        for (Partida partida : visitante.stream().limit(10).toList()) {

            escanteios += partida.getEscanteiosMandanteHT();
            escanteios += partida.getEscanteiosVisitanteHT();

            jogos++;
        }

        return (double) escanteios / jogos;
    }

    private double calcularRaceEscanteios(
            List<Partida> mandante,
            List<Partida> visitante
    ) {

        int race = 0;
        int jogos = 0;

        for (Partida partida : mandante.stream().limit(10).toList()) {

            race += partida.getEscanteios15Mandante();
            race += partida.getEscanteios15Visitante();

            jogos++;
        }

        for (Partida partida : visitante.stream().limit(10).toList()) {

            race += partida.getEscanteios15Mandante();
            race += partida.getEscanteios15Visitante();

            jogos++;
        }

        return (double) race / jogos;
    }

    private boolean identificarPressaoAlta(
            List<Partida> partidas
    ) {

        long jogosComGolAntes30 =
                partidas.stream()
                        .filter(
                                p -> p.getGolsAntes30Mandante() > 0
                        )
                        .count();

        return jogosComGolAntes30 >= 6;
    }
}
