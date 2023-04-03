package com.painel.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.painel.painel.models.Chamada;

public interface ChamadaRepository extends JpaRepository<Chamada, Integer>{
    
}
