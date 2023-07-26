package com.painel.painel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.painel.painel.models.Ambiente;
import com.painel.painel.models.Guiche;

public interface GuicheRepository extends JpaRepository<Guiche, Integer> {

    List<Guiche> findByAmbiente(Ambiente ambiente);
    
}
