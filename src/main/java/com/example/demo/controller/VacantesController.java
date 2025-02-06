package com.example.demo.controller;

import com.example.demo.model.Vacante;
import com.example.demo.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    IVacantesService vacantesService;

    @RequestMapping(value = "/view/{idVacante}", method = RequestMethod.GET)
    public String detalle(@PathVariable int idVacante, Model model) {
        Vacante vacante = vacantesService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        return "/detalle";
    }
}
