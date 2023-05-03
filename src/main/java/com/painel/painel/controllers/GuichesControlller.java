package com.painel.painel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Guiche;
import com.painel.painel.repositories.AmbienteRepository;
import com.painel.painel.repositories.GuicheRepository;
import com.painel.painel.services.GuicheService;

@Controller
public class GuichesControlller {

    @Autowired
    private GuicheRepository guicheRepository;

    @Autowired
    private GuicheService guicheService;

    @Autowired
    private AmbienteRepository ambienteRepository;

    @GetMapping("/guicheCadastro")
    public ModelAndView guiches() {

        ModelAndView mv = new ModelAndView("guiches");

        mv.addObject("guiche", new Guiche());
        mv.addObject("list_ambiente", ambienteRepository.findAll());
        mv.addObject("list_guiche", guicheRepository.findAll());

        return mv;
    }

    @PostMapping("/saveGuiche")
    public ModelAndView save(Guiche guiche) {

        ModelAndView mv = new ModelAndView();

        guicheService.addGuiche(guiche);

        mv.setViewName("redirect:/guicheCadastro");

        return mv;
    }

    @GetMapping("guicheCadastro/alterarGuiche/{id}")
    public ModelAndView alterarGuiche(@PathVariable("id") Integer id) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("guiches_edit");
        Guiche guiche = guicheRepository.getReferenceById(id);
        mv.addObject("guiche", guiche);
        mv.addObject("list_ambiente", ambienteRepository.findAll());

        return mv;
    }

    @PostMapping("/alterarGuiche")
    public ModelAndView alterar(Guiche guiche) {

        ModelAndView mv = new ModelAndView();

        guicheRepository.save(guiche);

        mv.setViewName("redirect:/guicheCadastro");

        return mv;
    }

    @GetMapping("excluirGuiche/{id}")
    public String excluir_guiche(@PathVariable("id") Integer id) {

        guicheService.deleteGuiche(id);

        return "redirect:/guicheCadastro";
    }
}
