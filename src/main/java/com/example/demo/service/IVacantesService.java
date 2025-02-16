package com.example.demo.service;

import com.example.demo.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer id);
    void guardar(Vacante vacante);
}
