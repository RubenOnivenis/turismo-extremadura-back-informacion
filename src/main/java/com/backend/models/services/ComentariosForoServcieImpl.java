package com.backend.models.services;

import com.backend.models.dao.ComentariosForoDao;
import com.backend.models.entity.ComentariosForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de ComentariosForoService **/
public class ComentariosForoServcieImpl implements ComentariosForoService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo comentariosForoDao **/
    private ComentariosForoDao comentariosForoDao;

    @Override
    /** Funcion de tipo lista del obj ComentariosForo, proveniente de la interfaz **/
    public List<ComentariosForo> findAll() {
        return comentariosForoDao.getComentariosForo();
    }

    @Override
    /** Funcion de tipo obj ComentariosForo, se le pasa la variable int idComentarioForo, proviene de la interfaz **/
    public ComentariosForo findById(int idComentarioForo) {
        return comentariosForoDao.getComentariosForoById(idComentarioForo);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj ComentariosForo y el metodo proviene de la interfaz **/
    public int save(ComentariosForo comentariosForo) {
        return comentariosForoDao.insert(comentariosForo);
    }

    @Override
    /** Funcion de tipo int, se le pasa la variable int idComentarioForo, proviene de la interfaz **/
    public int delete(int idComentarioForo) {
        return comentariosForoDao.delete(idComentarioForo);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj ComentariosForo y el metodo proviene de la interfaz **/
    public int insert(ComentariosForo comentariosForo) {
        return comentariosForoDao.update(comentariosForo);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj ComentariosForo y el metodo proviene de la interfaz **/
    public int update(ComentariosForo comentariosForo) {
        return comentariosForoDao.update(comentariosForo);
    }
}
