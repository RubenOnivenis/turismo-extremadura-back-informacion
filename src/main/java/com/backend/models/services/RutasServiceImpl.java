package com.backend.models.services;

import com.backend.models.dao.RutasDao;
import com.backend.models.entity.Alojamientos;
import com.backend.models.entity.Rutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de RutasService **/
public class RutasServiceImpl implements RutasService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo rutasDao **/
    private RutasDao rutasDao;

    /** Funcion de tipo lista del obj Rutas, proveniente de la interfaz **/
    public List<Rutas> findAll() {
        return rutasDao.getRuta();
    }

    @Override
    /** Funcion de tipo lista del obj Rutas, se le pasa la variable Strin nombre y proveniente de la interfaz **/
    public List<Rutas> getRutasByName(String nombre) {
        return rutasDao.getRutasByName(nombre);
    }

}
