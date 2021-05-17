package com.backend.models.dao;

import com.backend.models.entity.Rutas;

import java.util.List;

public interface RutasDao {

    List<Rutas> getRuta();

    List<Rutas> getRutasByName(String nombre);
}
