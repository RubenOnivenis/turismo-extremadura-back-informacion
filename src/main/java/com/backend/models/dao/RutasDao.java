package com.backend.models.dao;

import com.backend.models.entity.Rutas;

import java.util.List;

public interface RutasDao {

    /** Metodo del tipo lista del obj Rutas **/
    List<Rutas> getRuta();

    /** Metodo de tipo Lista del obj Rutas al que se le pasa la varibale Strin nombre **/
    List<Rutas> getRutasByName(String nombre);
}
