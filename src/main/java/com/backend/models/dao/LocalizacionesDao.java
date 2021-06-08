package com.backend.models.dao;

import com.backend.models.entity.Localizaciones;

import java.util.List;

public interface LocalizacionesDao {

    /** Método de tipo lista del obj Localizaciones **/
    List<Localizaciones> getLocalizaciones();

    /** Método de tipo Lista del obj de Localizaciones al que se le pasa la variable String nombre **/
    List<Localizaciones> getLocalizacionesByNombre(String nombre);
}
