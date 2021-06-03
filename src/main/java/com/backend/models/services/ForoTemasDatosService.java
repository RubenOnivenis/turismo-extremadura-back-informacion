package com.backend.models.services;

import com.backend.models.entity.ForoTemasDatos;

import java.util.List;

public interface ForoTemasDatosService {

    List<ForoTemasDatos> findAll();

    ForoTemasDatos findById(int idTema);
    
    public List<ForoTemasDatos> findByName(String nombre);
}
