package com.painel.painel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.painel.painel.models.Guiche;

public interface GuicheRepository extends JpaRepository<Guiche, Integer> {
    
}
