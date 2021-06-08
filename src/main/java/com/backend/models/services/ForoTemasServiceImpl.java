package com.backend.models.services;

import com.backend.models.dao.ForoTemasDao;
import com.backend.models.entity.ForoTemas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de ForoTemasService **/
public class ForoTemasServiceImpl implements ForoTemasService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo foroTemasDao **/
    private ForoTemasDao foroTemasDao;

    @Override
    /** Funcion de tipo lista del obj ForoTemas, proveniente de la interfaz **/
    public List<ForoTemas> findAll() {
        return foroTemasDao.getForoTemas();
    }

    @Override
    /** Funcion de tipo obj ForoTemas, se le pasa la variable int idTema, proviene de la interfaz **/
    public ForoTemas findById(int idTema) {
        return foroTemasDao.getForoTemasById(idTema);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj foroTemas y el metodo proviene de la interfaz **/
    public int save(ForoTemas foroTemas) {
        return foroTemasDao.insert(foroTemas);
    }

    @Override
    /** Funcion de tipo de tipo int, se le pasa la variable int idTema, proviene de la interfaz **/
    public int delete(int idTema) {
        return foroTemasDao.delete(idTema);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj foroTemas y el metodo proviene de la interfaz **/
    public int insert(ForoTemas foroTemas) {
        return foroTemasDao.update(foroTemas);
    }

    @Override
    /** Funcion de tipo int, se le pasa el obj foroTemas y el metodo proviene de la interfaz **/
    public int update(ForoTemas foroTemas) {
        return foroTemasDao.update(foroTemas);
    }
}
