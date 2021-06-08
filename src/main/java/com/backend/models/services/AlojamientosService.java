package com.backend.models.services;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosService {

    // todo funcido de buscar todos los alojamientos
    List<Alojamientos> findAll();

    List<Alojamientos> getAlojamientosByName(String nombre);

    Alojamientos findById(int id_alojamiento);
}
