package com.backend.models.dao;

import java.util.List;

import com.backend.models.entity.ForoTemasDatos;

public interface ForoTemasDatosDao {

    List<ForoTemasDatos> getForoTemasDatos();

    ForoTemasDatos getForoTemasDatosById(int idTema);
    
    List<ForoTemasDatos> getTemasByNombre(String nombre);

}
