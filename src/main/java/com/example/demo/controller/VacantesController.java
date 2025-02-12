package com.example.demo.controller;

import com.example.demo.model.Vacante;
import com.example.demo.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    IVacantesService vacantesService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vacante vacante) {

        System.out.println("vacante = " + vacante);

        return "/vacantes/listVacantes";
    }


    /*
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String estatus, @RequestParam String fecha, @RequestParam int destacado, @RequestParam double salario, @RequestParam String detalles) {

        System.out.println("Nombre: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estatus: " + estatus);
        System.out.println("Fecha: " + fecha);
        System.out.println("destacado: " + destacado);
        System.out.println("Salario: " + salario);
        System.out.println("Detalles: " + detalles);

        return "/vacantes/listVacantes";
    }
    */

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String crear() {
        return "/vacantes/formVacante";
    }

    @RequestMapping(value = "/view/{idVacante}", method = RequestMethod.GET)
    public String detalle(@PathVariable int idVacante, Model model) {
        Vacante vacante = vacantesService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        return "/detalle";
    }
}
