package com.backend.models.services;

import com.backend.models.entity.ForoTemas;

import java.util.List;

/** Interfaz del servicio ForoTemas **/
public interface ForoTemasService {

    /** Funcion tipo lista del obj ForoTemas **/
    List<ForoTemas> findAll();

    /** Funcion tipo obj ForoTemas se le pasa la variabla int idTema **/
    ForoTemas findById(int idTema);

    /** Función tipo int se le pasa el obj ForoTemas **/
    int save(ForoTemas foroTemas);

    /** Funcion tipo int se le pasa la variable tipo int idTema **/
    int delete(int idTema);

    /** Función tipo int se le pasa el obj ForoTemas **/
    int insert (ForoTemas foroTemas);

    /** Función tipo int se le pasa el obj ForoTemas **/
    int update (ForoTemas foroTemas);

}
