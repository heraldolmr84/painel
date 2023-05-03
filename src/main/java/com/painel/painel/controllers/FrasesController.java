package com.painel.painel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Frases;
import com.painel.painel.repositories.AmbienteRepository;
import com.painel.painel.repositories.FrasesRepository;
import com.painel.painel.services.FraseService;

@Controller
public class FrasesController {

    @Autowired
    private AmbienteRepository ar;

    @Autowired
    private FrasesRepository fr;

    @Autowired
    private FraseService fs;

    @GetMapping("/fraseCadastro")
    public ModelAndView frases() {

        ModelAndView mv = new ModelAndView("frases");

        mv.addObject("frase", new Frases());
        mv.addObject("list_ambiente", ar.findAll());

        mv.addObject("list_frase", fr.findAll());

        return mv;
    }

    @PostMapping("/saveFrase")
    public ModelAndView save(Frases frase) {

        ModelAndView mv = new ModelAndView();

        fs.addFrase(frase);

        mv.setViewName("redirect:/fraseCadastro");

        return mv;
    }

    @GetMapping("fraseCadastro/alterarFrase/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("frases_edit");
        Frases frase = fr.getReferenceById(id);
        mv.addObject("frase", frase);
        mv.addObject("list_ambiente", ar.findAll());

        return mv;
    }

    @PostMapping("/alterarFrase")
    public ModelAndView alterar(Frases frase) {

        ModelAndView mv = new ModelAndView();

        fr.save(frase);

        mv.setViewName("redirect:/fraseCadastro");

        return mv;
    }

    @GetMapping("excluirFrase/{id}")
    public String excluir(@PathVariable("id") Integer id) {

        fs.deleteFrase(id);

        return "redirect:/fraseCadastro";
    }
    
}
