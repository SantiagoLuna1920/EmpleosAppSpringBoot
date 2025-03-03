package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriasService categoriasService;

    // @GetMapping("/index")
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        List<Categoria> categorias = categoriasService.buscarTodas();
        model.addAttribute("categorias", categorias);
        return "/categorias/listCategorias";
    }
    // @GetMapping("/create")
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String crear(Categoria categoria) {
        return "/categorias/formCategoria";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Categoria categoria, BindingResult result, RedirectAttributes attributes) {

        if( result.hasErrors() ) {
            System.out.println(categoria);
            return "/categorias/formCategoria";
        }
        System.out.println(categoria);
        categoriasService.guardar(categoria);
        attributes.addFlashAttribute("msg", "Registro guardado.");
        return "redirect:/categorias/index";
    }

}
