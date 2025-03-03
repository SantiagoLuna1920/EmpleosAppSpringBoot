package com.example.demo.service;

import com.example.demo.model.Categoria;

import java.util.List;

public interface ICategoriasService {
    void guardar( Categoria categoria );
    List<Categoria> buscarTodas();
    Categoria buscarPorId( Integer id );
}
