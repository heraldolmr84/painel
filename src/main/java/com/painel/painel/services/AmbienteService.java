package com.painel.painel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.painel.painel.models.Ambiente;
import com.painel.painel.repositories.AmbienteRepository;

import jakarta.transaction.Transactional;

@Service
public class AmbienteService {
    
    @Autowired
    private AmbienteRepository ar;

    @Transactional
    public void addAmbient(Ambiente ambiente) {

        ar.save(ambiente);
        
    }

    public List<Ambiente> listAmbiente() {
        return (List<Ambiente>) ar.findAll();
    }

    public Ambiente finbById(Integer id) {

        Optional<Ambiente> ambiente = this.ar.findById(id);

        return ambiente.orElseThrow(() -> new RuntimeException(
            "Ambiente não encontrado! " + id + ", tipo: " +Ambiente.class.getName()
        ));
    }
}
