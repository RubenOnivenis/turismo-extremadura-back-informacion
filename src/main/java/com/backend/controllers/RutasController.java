package com.backend.controllers;

import com.backend.models.entity.Rutas;
import com.backend.models.services.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RutasController {

    @Autowired
    private RutasService rutasService;

    // Controlador para ver todas las rutas
    @GetMapping("/rutas")
    public List<Rutas> rutasIndex(){

        return rutasService.findAll();
    }

    // Controlador para ver los rutas según el nombre, este sirve para el buscador del front
    @GetMapping("/rutas/nombre/{nombre}")
    public List<Rutas> getRutasByName(@PathVariable String nombre){
        return rutasService.getRutasByName(nombre);
    }
}
