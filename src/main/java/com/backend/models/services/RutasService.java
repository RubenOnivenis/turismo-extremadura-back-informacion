package com.backend.models.services;

import com.backend.models.entity.Rutas;

import java.util.List;

/** Interfaz del servicio Rutas **/
public interface RutasService {

    /** Funcion tipo lista del obj Rutas **/
    List<Rutas> findAll();

    /** Funcion tipo lista del obj Rutas se le pasa la variable Strin nombre **/
    List<Rutas> getRutasByName(String nombre);
}
