package com.example.demo.controller;

import com.example.demo.model.Vacante;
import com.example.demo.service.ICategoriasService;
import com.example.demo.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    IVacantesService vacantesService;

    @Autowired
    ICategoriasService categoriasService;
//hola
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<Vacante> listaVacantes = vacantesService.buscarTodas();
        model.addAttribute("listaVacantes", listaVacantes);
        return "/vacantes/listVacantes";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vacante vacante, BindingResult result, RedirectAttributes attributes, Model model) {
//el bindingresult me ayuda a atrapar los errores que haya cuando haga un post o get y atrape los valores, recordar que spring trae todos los valores del post o get de acuerdo al tipo de dato que quiero guardar, por ejemplo, salario en double o int, nombre en string, y fecha me la trae como string, osea, spring me trata de parsear los valores de la web de acuerdo a la variable en la que la quiera guardar, el problema está en las fechas
        System.out.println("-----");

        if( result.hasErrors() ) {
            for (ObjectError error : result.getAllErrors()){
                System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
            }
            model.addAttribute("categorias", categoriasService.buscarTodas());
            return "/vacantes/formVacante";
        }

        System.out.println(vacante);
        vacantesService.guardar(vacante);
        //model.addAttribute("msg", "Registro guardado");
        // al realizar la peticion al index y al renderizar el listVacantes.html, el atributo msg se perderá, ya que no le estoy pasando el atributo entre peticiones, por lo que ese atributo msg solo estará disponible en ese controlador save, pero el redirect: me hace una nueva peticion al controlador con el metodo index, por lo que no se guardará el atributo, para corregir esto, se usa el RedirectAttributes, y con el metodo addFlashAttributes le pasamos el atributo a la sig peticion, cuando recargue la pagina o haga otra peticion posterior, ya ese estado msg se perderá
        attributes.addFlashAttribute("msg", "Registro guardado");
        return "redirect:/vacantes/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String crear(Vacante vacante, Model model) {
        model.addAttribute("categorias", categoriasService.buscarTodas());
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
