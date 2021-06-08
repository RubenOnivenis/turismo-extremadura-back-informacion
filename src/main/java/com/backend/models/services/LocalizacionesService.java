package com.backend.models.services;

import com.backend.models.entity.Localizaciones;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/** Interfaz del servicio Localizaciones **/
public interface LocalizacionesService {

    /** Funcion tipo lista del obj Localizaciones **/
    public List<Localizaciones> findAll();

    /** Funcion tipo lista del obj Localizaciones se le pasa la variable String nombre **/
    public List<Localizaciones> findByName(String nombre);
}
