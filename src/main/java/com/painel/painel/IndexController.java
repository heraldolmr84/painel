package com.painel.painel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.painel.painel.models.Ambiente;

@Controller
public class IndexController {
    
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

        return mv;
    }
}
