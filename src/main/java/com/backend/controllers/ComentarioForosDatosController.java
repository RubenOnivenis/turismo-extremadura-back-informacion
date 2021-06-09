package com.backend.controllers;

import com.backend.models.entity.ComentariosForoDatos;
import com.backend.models.services.ComentariosForoDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Anotacion que nos indica que es una clase para controladores **/
@RestController
/** Anotacion para el mapeo, le indicamos que /api ira al principio **/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular **/
@CrossOrigin(origins = {"http://localhost:4200"})
public class ComentarioForosDatosController {

    /** Esta anotacion nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Servicio de los comentariosDatos **/
    ComentariosForoDatosService comentariosForoDatosService;

    /** Anotacion con la cual indicamos que es una petición de tipo GET y en el endpoint se escribe /comentarios_foro_datos **/
    @GetMapping("/comentarios_foro_datos")
    /** Controlador para ver todos los comentarios del foro **/
    public List<ComentariosForoDatos> findAll(){
        return comentariosForoDatosService.findAll();
    }

    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /comentarios_foro_datos/{idTema} **/
    @GetMapping("/comentarios_foro_datos/{idTema}")
    /** Controlador para ver todos los comentarios del foro segun el idTema **/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public List<ComentariosForoDatos> show(@PathVariable int idTema){
        return comentariosForoDatosService.findById(idTema);
    }
}
