package com.backend.models.dao;

import com.backend.models.entity.ComentariosForoDatos;

import java.util.List;

public interface ComentarioForoDatosDao {

    /** Metodo tipo lista del obj ComentariosForoDatos **/
    List<ComentariosForoDatos> getComentariosForoDatos();

    /** Metodo tipo lista del obj ComentariosForoDatos que se le pasa la variable int idTema **/
    List<ComentariosForoDatos> getComentariosForoDatosById(int idTema);
}
