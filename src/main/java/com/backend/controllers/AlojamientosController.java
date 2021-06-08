package com.backend.controllers;

import com.backend.models.entity.Alojamientos;

import com.backend.models.services.AlojamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Anotacion que nos indica que es una clase para controladores **/
@RestController
/** Anotacion para el mapeo, le indicamos que /api ira al principio **/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular **/
@CrossOrigin(origins = {"http://localhost:4200"})
public class AlojamientosController {

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Servicio del alojamiento **/
    AlojamientosService alojamientosService;

    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /alojamientos **/
    @GetMapping("/alojamientos")
    /** Controlador para ver todas los alojamientos **/
    public List<Alojamientos> alojamientosIndex(){

        return alojamientosService.findAll();
    }

    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /alojamientos/nombre/{nombre} **/
    @GetMapping("/alojamientos/nombre/{nombre}")
    /** Controlador para ver los alojamientos según el nombre, este sirve para el buscador del front
     Con @PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public List<Alojamientos> getAlojamientosByName(@PathVariable String nombre){
        return alojamientosService.getAlojamientosByName(nombre);
    }
    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /alojamientos/{id_alojamiento} **/
    @GetMapping("/alojamiento/{id_alojamiento}")
    /** Controlador para ver un solo alojamiento por el id.
     Con @PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public Alojamientos show(@PathVariable int id_alojamiento){

        return alojamientosService.findById(id_alojamiento);
    }
}
