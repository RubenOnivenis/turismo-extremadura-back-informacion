package com.backend.models.services;

import com.backend.models.dao.ComentarioForoDatosDao;
import com.backend.models.entity.ComentariosForoDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de ComentariosForoDatosService **/
public class ComentarioForoDatosImpl implements ComentariosForoDatosService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo ComentarioForoDatosDao **/
    private ComentarioForoDatosDao comentarioForoDatosDao;

    @Override
    /** Funcion de tipo lista del obj ComentariosForoDatos, proveniente de la interfaz **/
    public List<ComentariosForoDatos> findAll() {
        return comentarioForoDatosDao.getComentariosForoDatos();
    }

    @Override
    /** Funcion de tipo lista del obj ComentariosForoDatos, se le pasa la variable int idTema, proveniente de la interfaz **/
    public List<ComentariosForoDatos> findById(int idTema) {
        return comentarioForoDatosDao.getComentariosForoDatosById(idTema);
    }
}
