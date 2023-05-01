package com.painel.painel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Ambiente;
import com.painel.painel.models.Guiche;
import com.painel.painel.repositories.AmbienteRepository;
import com.painel.painel.repositories.GuicheRepository;

@Controller
public class IndexController {

    @Autowired
    private AmbienteRepository ar;

    @Autowired
    private GuicheRepository gr;
    
    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/painelChamada")
    public ModelAndView painelChamada() {

        ModelAndView mv = new ModelAndView("telaChamada");

        return mv;
    }

    @GetMapping("/ambienteCadastro")
    public ModelAndView ambiente() {

        ModelAndView mv = new ModelAndView("ambientes");

        mv.addObject("ambiente", new Ambiente());
        mv.addObject("list_ambiente", ar.findAll());

        return mv;
    }

    @GetMapping("/guicheCadastro")
    public ModelAndView guiches() {

        ModelAndView mv = new ModelAndView("guiches");

        mv.addObject("guiche", new Guiche());
        mv.addObject("list_ambiente", ar.findAll());
        mv.addObject("list_guiche", gr.findAll());

        return mv;
    }

    @GetMapping("/chamarPainel")
    public ModelAndView chamarPainel() {
        
        ModelAndView mv = new ModelAndView("guicheChamada");

        return mv;
    }
}
