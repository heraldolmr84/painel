package com.painel.painel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/chamarPainel")
    public ModelAndView chamarPainel() {
        
        ModelAndView mv = new ModelAndView("guicheChamada");

        return mv;
    }
}
