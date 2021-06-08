package com.backend.models.dao;

import java.util.List;

import com.backend.models.entity.ForoTemasDatos;

public interface ForoTemasDatosDao {

    /** Metodo tipo Lista del obj ForoTemasDatos **/
    List<ForoTemasDatos> getForoTemasDatos();

    /** Metodo tipo obj ForoTemasDatos al que se le pasa la variable int idTema **/
    ForoTemasDatos getForoTemasDatosById(int idTema);

    /** Metodo de tipo lista del obj ForoTemasDatos al que se le pasa la variable String nombre **/
    List<ForoTemasDatos> getTemasByNombre(String nombre);

}
