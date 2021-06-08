package com.backend.models.services;

import com.backend.models.entity.ForoTemasDatos;

import java.util.List;

/** Interfaz del servicio de ForoTemasDatos **/
public interface ForoTemasDatosService {

    /** Funcion de tipo lista del obj foroTemasDatos **/
    List<ForoTemasDatos> findAll();

    /** Funcion de tipo obj foroTemasDatos para mostrar según el id, se le pasa la variable int idTema **/
    ForoTemasDatos findById(int idTema);

    /** Funcion tipo lista del obj ForoTemasDatos para mostrar según el nombre, se le pasa la variable String nombre **/
    List<ForoTemasDatos> findByName(String nombre);
}
