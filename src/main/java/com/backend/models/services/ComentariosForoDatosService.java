package com.backend.models.services;

import com.backend.models.entity.ComentariosForoDatos;

import java.util.List;

public interface ComentariosForoDatosService {

    List<ComentariosForoDatos> findAll();

    List<ComentariosForoDatos> findById(int idTema);
}
