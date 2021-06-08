package com.backend.controllers;

import com.backend.models.entity.Localizaciones;
import com.backend.models.services.LocalizacionesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Anotación que nos indica que es una clase para controladores **/
@RestController
/** Anotación para el mapeo, le indicamos que /api ira al principio **/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular **/
@CrossOrigin(origins = {"http://localhost:4200"})
public class LocalizacionesController {

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Servicio de localizaciones **/
    private LocalizacionesService localizacionesService;

     /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /localizaciones **/
    @GetMapping("/localizaciones")
    /** Controlador para ver todas las localizaciones **/
    public List<Localizaciones> localizacionesIndex(){

        return localizacionesService.findAll();
    }

    /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /localizaciones/nombre/{nombre} **/
    @GetMapping("/localizaciones/nombre/{nombre}")
    /** Controlador para ver las localizaciones según el nombre, este sirve para el buscador del front **/
    /** Con @PathVariable configuramos la variable dentro del propio segmento de la URL **/
	public List<Localizaciones> show(@PathVariable String nombre) {
		return localizacionesService.findByName(nombre);
	}
}
