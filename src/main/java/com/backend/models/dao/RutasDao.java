package com.backend.models.dao;

import com.backend.models.entity.Rutas;

import java.util.List;

public interface RutasDao {

    /** Método del tipo lista del obj Rutas **/
    List<Rutas> getRuta();

    // todo Método de tipo Lista del obj Rutas al que se le pasa la varibale Strin nombre
    List<Rutas> getRutasByName(String nombre);
}
