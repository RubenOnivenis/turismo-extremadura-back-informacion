package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;

import java.util.List;

public interface ComentariosForoDao {

    /** Método tipo lista del obj ComentariosForo **/
    List<ComentariosForo> getComentariosForo();

    /** Método tipo lista del obj ComentariosForo que se le pasa la variable int idComentarioForo **/
    ComentariosForo getComentariosForoById(int idComentarioForo);

    /** Método tipo int al que se le pasa el obj comentariosForo **/
    int insert(ComentariosForo comentariosForo);

    /** Método tipo int al que se le pasa el obj comentariosForo **/
    int update(ComentariosForo comentariosForo);

    /** Método tipo int al que se le pasa la variable int idComentarioForo **/
    int delete(int idComentarioForo);
}
