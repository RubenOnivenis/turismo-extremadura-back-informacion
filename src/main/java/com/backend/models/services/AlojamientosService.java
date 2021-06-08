package com.backend.models.services;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosService {

    /** función tipo lista del obj de buscar todos los alojamientos **/
    List<Alojamientos> findAll();

    List<Alojamientos> getAlojamientosByName(String nombre);

    Alojamientos findById(int id_alojamiento);
}
