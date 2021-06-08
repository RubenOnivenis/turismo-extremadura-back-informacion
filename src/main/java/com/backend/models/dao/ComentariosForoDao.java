package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;

import java.util.List;

public interface ComentariosForoDao {

    /** Metodo tipo lista del obj ComentariosForo **/
    List<ComentariosForo> getComentariosForo();

    /** Metodo tipo lista del obj ComentariosForo que se le pasa la variable int idComentarioForo **/
    ComentariosForo getComentariosForoById(int idComentarioForo);

    /** Metodo tipo int al que se le pasa el obj comentariosForo **/
    int insert(ComentariosForo comentariosForo);

    /** Metodo tipo int al que se le pasa el obj comentariosForo **/
    int update(ComentariosForo comentariosForo);

    /** Metodo tipo int al que se le pasa la variable int idComentarioForo **/
    int delete(int idComentarioForo);
}
