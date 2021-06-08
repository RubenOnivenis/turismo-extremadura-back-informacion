package com.backend.models.services;

import com.backend.models.dao.ForoTemasDatosDao;
import com.backend.models.entity.ForoTemasDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de ForoTemasDatosService **/
public class ForoTemasDatosServiceImpl implements ForoTemasDatosService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo foroTemasDatosDao **/
    private ForoTemasDatosDao foroTemasDatosDao;

    @Override
    /** Funcion de tipo lista del obj ForoTemasDatos, proveniente de la interfaz **/
    public List<ForoTemasDatos> findAll() {
        return foroTemasDatosDao.getForoTemasDatos();
    }

    @Override
    /** Funcion de tipo obj ForoTemasDatos, se le pasa la variable int idTema, proviene de la interfaz **/
    public ForoTemasDatos findById(int idTema) {
        return foroTemasDatosDao.getForoTemasDatosById(idTema);
    }
    
    @Override
    /** Funcion de tipo lista del obj ForoTemasDatos, se le pasa la variable String nombre y proveniente de la interfaz **/
	public List<ForoTemasDatos> findByName(String nombre) {
		return foroTemasDatosDao.getTemasByNombre(nombre);
	}
}
