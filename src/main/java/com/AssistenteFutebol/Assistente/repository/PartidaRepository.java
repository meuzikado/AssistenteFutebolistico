package com.AssistenteFutebol.Assistente.repository;

import com.AssistenteFutebol.Assistente.entity.Partida;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository
        extends JpaRepository<Partida, Long> {

    @Query("""
        SELECT p
        FROM Partida p
        WHERE p.mandante.id = :timeId
        OR p.visitante.id = :timeId
        ORDER BY p.data DESC
    """)
    List<Partida> buscarUltimosJogos(Long timeId);
}
