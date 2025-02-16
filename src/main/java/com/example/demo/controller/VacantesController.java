package com.example.demo.controller;

import com.example.demo.model.Vacante;
import com.example.demo.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    IVacantesService vacantesService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Vacante> listaVacantes = vacantesService.buscarTodas();
        model.addAttribute("listaVacantes", listaVacantes);
        return "/vacantes/listVacantes";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vacante vacante, BindingResult result, Model model, @RequestParam String fecha) {
//el bindingresult me ayuda a atrapar los errores que haya cuando haga un post o get y atrape los valores, recordar que spring trae todos los valores del post o get de acuerdo al tipo de dato que quiero guardar, por ejemplo, salario en double o int, nombre en string, y fecha me la trae como string, osea, spring me trata de parsear los valores de la web de acuerdo a la variable en la que la quiera guardar, el problema está en las fechas

      System.out.println("Fecha = " + fecha);
        if( result.hasErrors() ) {
            for (ObjectError error : result.getAllErrors()){
                System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
            }

            return "/vacantes/formVacante";
        }

        vacantesService.guardar(vacante);
        List<Vacante> listaVacantes = vacantesService.buscarTodas();
        model.addAttribute("listaVacantes", listaVacantes);

        return "/vacantes/listVacantes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String crear(Model models) {
        models.addAttribute("miVacante", new Vacante());
        return "/vacantes/formVacante";
    }

    @RequestMapping(value = "/view/{idVacante}", method = RequestMethod.GET)
    public String detalle(@PathVariable int idVacante, Model model) {
        Vacante vacante = vacantesService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        return "/detalle";
    }



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
