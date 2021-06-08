package com.backend.models.dao;

import com.backend.models.entity.Alojamientos;

import java.util.List;

public interface AlojamientosDao {

    /** Metodo tipo lista con el obj alojamientos **/
    List<Alojamientos> getAlojamientos();

    /** Metodo tipo lista con el obj alojamientos que se le pasa la variable string nombre **/
    List<Alojamientos> getAlojamientosByName(String nombre);

    /** Metodo tipo obj alojamientos que se le pasa la variable int id_alojamiento **/
    Alojamientos getAlojamientoById(int id_alojamiento);
}
