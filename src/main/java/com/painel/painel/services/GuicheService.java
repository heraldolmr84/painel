package com.painel.painel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.painel.painel.models.Guiche;
import com.painel.painel.repositories.GuicheRepository;

@Service
public class GuicheService {

    @Autowired
    private GuicheRepository gr;

    public List<Guiche> listGuiche() {
        return (List<Guiche>) gr.findAll();
    }

    public void addGuiche(Guiche guiche) {
        gr.save(guiche);
    }

    public void deleteGuiche(Integer id) {
        gr.deleteById(id);
    }

}
