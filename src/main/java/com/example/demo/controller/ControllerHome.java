package com.example.demo.controller;

import com.example.demo.model.Vacante;
import com.example.demo.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerHome {

    @Autowired
    private IVacantesService vacantesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Vacante> listaVacantes = vacantesService.buscarTodas();
        model.addAttribute("listaVacantes", listaVacantes);
        return "/home";
    }
}
