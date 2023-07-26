package com.painel.painel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.painel.painel.models.Frases;
import com.painel.painel.repositories.FrasesRepository;

@Service
public class FraseService {

    @Autowired
    private FrasesRepository fr;
    
    public void listarFrase() {

    }

    public void addFrase(Frases frase) {

        fr.save(frase);
    }

    public void deleteFrase(Integer id) {
        fr.deleteById(id);
    }
}
