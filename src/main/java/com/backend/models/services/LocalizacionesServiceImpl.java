package com.backend.models.services;

import com.backend.models.dao.LocalizacionesDao;
import com.backend.models.entity.Localizaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de LocalizacionesService **/
public class LocalizacionesServiceImpl implements LocalizacionesService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo localizacionesDao **/
    private LocalizacionesDao localizacionesDao;

    /** Funcion de tipo lista del obj Localizaciones, proveniente de la interfaz **/
    public List<Localizaciones> findAll(){
        return localizacionesDao.getLocalizaciones();
    }
    
    @Override
    /** Funcion de tipo lista del obj Localizaciones, se le pasa la variable Strin nombre y proveniente de la interfaz **/
	public List<Localizaciones> findByName(String nombre) {
		return localizacionesDao.getLocalizacionesByNombre(nombre);
	}
}
