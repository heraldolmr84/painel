package com.painel.painel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Ambiente;
import com.painel.painel.repositories.AmbienteRepository;
import com.painel.painel.services.AmbienteService;

@Controller
public class AmbientesController {

    @Autowired
    private AmbienteService ambienteService;

    @Autowired
    private AmbienteRepository ar;

    @GetMapping("/ambienteCadastro")
    public ModelAndView ambiente() {

        ModelAndView mv = new ModelAndView("ambientes");

        mv.addObject("ambiente", new Ambiente());
        mv.addObject("list_ambiente", ar.findAll());

        return mv;
    }    

    @PostMapping("/saveAmbient")
    public ModelAndView save(Ambiente ambiente) {

        ModelAndView mv = new ModelAndView();

        ambienteService.addAmbient(ambiente);

        mv.setViewName("redirect:/ambienteCadastro");

        return mv;
    }

    @GetMapping("ambienteCadastro/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ambientes_edit");
        Ambiente ambiente = ar.getReferenceById(id);
        mv.addObject("ambiente", ambiente);

        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Ambiente ambiente) {

        ModelAndView mv = new ModelAndView();

        ar.save(ambiente);

        mv.setViewName("redirect:/ambienteCadastro");

        return mv;
    }

    @GetMapping("excluir/{id}")
    public String excluir_ambiente(@PathVariable("id") Integer id) {

        ar.deleteById(id);

        return "redirect:/ambienteCadastro";
    }

}
