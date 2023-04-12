package com.painel.painel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.painel.painel.models.Ambiente;
import com.painel.painel.repositories.AmbienteRepository;

@Service
public class AmbienteService {
    
    @Autowired
    private AmbienteRepository ar;

    public void addAmbient(Ambiente ambiente) {

        ar.save(ambiente);
        
    }

    public List<Ambiente> listAmbiente() {
        return (List<Ambiente>) ar.findAll();
    }
}
