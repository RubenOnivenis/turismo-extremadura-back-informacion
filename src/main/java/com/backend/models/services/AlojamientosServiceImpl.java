package com.backend.models.services;

import com.backend.models.dao.AlojamientosDao;
import com.backend.models.entity.Alojamientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de alojamientosService **/
public class AlojamientosServiceImpl implements AlojamientosService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo alojamientosDao **/
    AlojamientosDao alojamientosDao;

    @Override
    /** Funcion de tipo lista del obj Alojamientos, proveniente de la interfaz **/
    public List<Alojamientos> findAll() {
        return alojamientosDao.getAlojamientos();
    }

    @Override
    /** Funcion de tipo lista del obj Alojamientos, se le pasa la variable String nombre, proveniene de la interfaz **/
    public List<Alojamientos> getAlojamientosByName(String nombre) {
        return alojamientosDao.getAlojamientosByName(nombre);
    }

    @Override
    /** Funcion de tipo obj alojamientos, se le pasa la variable int id_alojamiento y proviene de la interfaz **/
    public Alojamientos findById(int id_alojamiento) {
        return alojamientosDao.getAlojamientoById(id_alojamiento);
    }
}
