package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

    // @GetMapping("/index")
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        return "/categorias/listCategorias";
    }
    // @GetMapping("/create")
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String crear() {
        return "/categorias/formCategoria";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String nombre, @RequestParam String descripcion) {
        System.out.printf("Nombre: %s\n", nombre);
        System.out.printf("Descripcion: %s\n", descripcion);
        return "/categorias/listCategorias";
    }

}
