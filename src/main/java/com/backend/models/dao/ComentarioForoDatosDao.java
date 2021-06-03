package com.backend.models.dao;

import com.backend.models.entity.ComentariosForoDatos;

import java.util.List;

public interface ComentarioForoDatosDao {

    List<ComentariosForoDatos> getComentariosForoDatos();

    List<ComentariosForoDatos> getComentariosForoDatosById(int idTema);
}
