package com.backend.models.services;

import com.backend.models.entity.ComentariosForo;

import java.util.List;

/** Interfaz del servicio de comentariosForo **/
public interface ComentariosForoService {

    /** Funcion de tipo lista del obj comentariosForo **/
    List<ComentariosForo> findAll();

    /** Funcion de tipo obj ComentariosForo para mostrar según el id, se le pasa la variable int idComentarioForo **/
    ComentariosForo findById(int idComentarioForo);

    /** Funcion de tipo int se le pasa el obj ComentariosForo **/
    int save(ComentariosForo comentariosForo);

    /** Funcion de tipo int se le pasa el la variable idComentarioForo **/
    int delete(int idComentarioForo);

    /** Funcion de tipo int se le pasa el obj ComentariosForo **/
    int insert (ComentariosForo comentariosForo);

    /** Funcion de tipo int se le pasa el obj ComentariosForo **/
    int update (ComentariosForo comentariosForo);

}
