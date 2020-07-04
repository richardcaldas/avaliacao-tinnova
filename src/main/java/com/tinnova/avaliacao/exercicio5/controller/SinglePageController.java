package com.tinnova.avaliacao.exercicio5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page")
public class SinglePageController {
    
    @GetMapping(value="/")
    public String getMainpage() {
        return "index";
    }

    @GetMapping(value="/novo-veiculo")
    public String getPageNovoVeiculo() {
        return "novo-veiculo";
    }
    
}