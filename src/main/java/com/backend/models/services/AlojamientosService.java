package com.backend.models.services;

import com.backend.models.entity.Alojamientos;

import java.util.List;

/** Interfaz del servicio de alojamientos **/
public interface AlojamientosService {

    /** Funcion tipo lista del obj de buscar todos los alojamientos **/
    List<Alojamientos> findAll();

    /** Funcion tipo lista del obj Alojamientos para mostrar un alojamiento por su nombre, se le pasa la variable Strin nombre **/
    List<Alojamientos> getAlojamientosByName(String nombre);

    /** Funcion de tipo obj Alojamientos para mostrar según el id, se le pasa la variable int id_alojamiento **/
    Alojamientos findById(int id_alojamiento);
}
