package com.backend.models.services;

import com.backend.models.entity.ComentariosForoDatos;

import java.util.List;

/** Interfaz del servicio de comentariosForoDatos **/
public interface ComentariosForoDatosService {

    /** Funcion de tipo lista del obj comentariosForoDatos **/
    List<ComentariosForoDatos> findAll();

    /** Funcion de tipo lista del obj comentariosForoDatos se le pasa la variable int idTema **/
    List<ComentariosForoDatos> findById(int idTema);
}
