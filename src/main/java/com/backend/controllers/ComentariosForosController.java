package com.backend.controllers;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.services.ComentariosForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Anotacion que nos indica que es una clase para controladores **/
@RestController
/** Anotacion para el mapeo, le indicamos que /api ira al principio **/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular **/
@CrossOrigin(origins = {"http://localhost:4200"})
public class ComentariosForosController {

    /** Esta anoacion nos permite inyectar la dependencia dentro de otras **/
    @Autowired private ComentariosForoService comentariosForoService;

    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /comentarios_foro **/
    @GetMapping("/comentarios_foro")
    /** Controlador que muestra todos loc comentarios del foro **/
    public List<ComentariosForo> comentariosForosIndex(){
        return comentariosForoService.findAll();
    }

    /** Anotacion con la cual indicamos que es una peticion de tipo GET y en el endpoint se escribe /comentarios_foro/{id_comentarios_foro} **/
    @GetMapping("/comentarios_foro/{id_comentario_foro}")
    /** Controlador que sirve para mostrar un comentario del foro según el id **/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public ComentariosForo show(@PathVariable int id_comentario_foro){
        return comentariosForoService.findById(id_comentario_foro);
    }

    /** Anotacion con la cual que indicamos que es una peticion post y en el endpoint se escribe /comentarios_foro **/
    @PostMapping("/comentario_foro")
    /** Anotacion que nos permite marcar el metodo con el código httm y la razon con la que es devuelto, en este caso es CREATED **/
    @ResponseStatus(HttpStatus.CREATED)
    /** Controlador para añadir un comentario **/
    /** Con RequestBody le pasamos el cuerpo entero del obj **/
    public int create(@RequestBody ComentariosForo comentariosForo){
        return comentariosForoService.save(comentariosForo);
    }

    /** Anotacion con la cual que indicamos que es una peticion put y en el endpoint se escribe /comentario_foro/{id_comentario_foro} **/
    @PutMapping("/comentario_foro/{id_comentario_foro}")
    /** Controlador que sirve para modificar un comentario **/
    /** Con RequestBody le pasamos el cuerpo entero del obj **/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public int update(@RequestBody ComentariosForo comentariosForo, @PathVariable int idComentarioForo){
        comentariosForo.setIdComentarioForo(idComentarioForo);
        return comentariosForoService.update(comentariosForo);
    }

    /** Anotacion con la cual que indicamos que es una peticion delete y en el endpoint se escribe /comentario_foro/{id_comentario_foro} **/
    @DeleteMapping("/comentario_foro/{id_comentario_foro}")
    /** Anotacion que nos permite marcar el metodo con el codigo http y la razon con la que es devuelto, en este caso es DELETE **/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /** Controlador que sirve para borrar un comentario del foro según el id **/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL **/
    public int delete(@PathVariable int id_comentario_foro){
        return comentariosForoService.delete(id_comentario_foro);
    }
}
