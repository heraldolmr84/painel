package com.painel.painel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Ambiente;
import com.painel.painel.services.AmbienteService;

@Controller
public class AmbientesController {

    @Autowired
    private AmbienteService ambienteService;
    

    @PostMapping("saveAmbient")
    public ModelAndView save(Ambiente ambiente) {

        ModelAndView mv = new ModelAndView();

        ambienteService.addAmbient(ambiente);

        mv.setViewName("redirect:/ambienteCadastro");

        return mv;
    }

    @GetMapping
    public ModelAndView listAllAmbient() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("ambientes");
        mv.addObject("ambiente", ambienteService.listAmbiente());

        return mv;
    }

}
