package com.backend.models.services;

import com.backend.models.entity.Rutas;

import java.util.List;

public interface RutasService {

    List<Rutas> findAll();

    List<Rutas> getRutasByName(String nombre);
}
