package com.backend.controllers;

import com.backend.models.entity.Rutas;
import com.backend.models.services.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Anotación que nos indica que es una clase para controladores **/
@RestController
/** Anotación para el mapeo, le indicamos que /api ira al principio**/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular**/
@CrossOrigin(origins = {"http://localhost:4200"})
public class RutasController {

    /** @Autowired nos permite inyectar la dependencia dentro de otras**/
    @Autowired
    /** Sevicio de rutas**/
    private RutasService rutasService;

    /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /rutas**/
    @GetMapping("/rutas")
    /** Controlador para ver todas las rutas**/
    public List<Rutas> rutasIndex(){

        return rutasService.findAll();
    }

    /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /rutas/nombre/{nombre}**/
    @GetMapping("/rutas/nombre/{nombre}")
    /** Controlador para ver los rutas según el nombre, este sirve para el buscador del front**/
    /** Con @PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public List<Rutas> getRutasByName(@PathVariable String nombre){
        return rutasService.getRutasByName(nombre);
    }
}
