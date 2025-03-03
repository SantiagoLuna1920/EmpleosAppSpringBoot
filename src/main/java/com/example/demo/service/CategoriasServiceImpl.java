package com.example.demo.service;

import com.example.demo.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

    private List<Categoria> categorias;

    public CategoriasServiceImpl() {
        categorias = new LinkedList<Categoria>();
        // Creamos algunas Categorias para poblar la lista ...

        // Categoria 1
        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNombre("Contabilidad");
        cat1.setDescripcion("Descripcion de la categoria Contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNombre("Ventas");
        cat2.setDescripcion("Trabajos relacionados con Ventas");


        // Categoria 3
        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setNombre("Comunicaciones");
        cat3.setDescripcion("Trabajos relacionados con Comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNombre("Arquitectura");
        cat4.setDescripcion("Trabajos de Arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNombre("Educacion");
        cat5.setDescripcion("Maestros, tutores, etc");

        categorias.add(cat1);
        categorias.add(cat2);
        categorias.add(cat3);
        categorias.add(cat4);
        categorias.add(cat5);
    }

    public void guardar( Categoria categoria ) {
        categorias.add(categoria);
    }

    public List<Categoria> buscarTodas() {
        return categorias;
    }

    public Categoria buscarPorId( Integer id ) {
        for( Categoria categoria : categorias ) {
            if( categoria.getId().equals(id) )
                return categoria;
        }
        return null;
    }
}
