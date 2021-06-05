package com.backend.controllers;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.services.ComentariosForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ComentariosForosController {

    @Autowired private ComentariosForoService comentariosForoService;

    @GetMapping("/comentarios_foro")
    public List<ComentariosForo> comentariosForosIndex(){
        return comentariosForoService.findAll();
    }

    @GetMapping("/comentarios_foro/{id_comentario_foro}")
    public ComentariosForo show(@PathVariable int id_comentario_foro){
        return comentariosForoService.findById(id_comentario_foro);
    }

    // Controlador para añadir un comentario
    @PostMapping("/comentario_foro") @ResponseStatus(HttpStatus.CREATED)
    public int create(@RequestBody ComentariosForo comentariosForo){
        return comentariosForoService.save(comentariosForo);
    }

    @PutMapping("/comentario_foro/{id_comentario_foro}")
    public int update(@RequestBody ComentariosForo comentariosForo, @PathVariable int idComentarioForo){
        comentariosForo.setIdComentarioForo(idComentarioForo);

        return comentariosForoService.update(comentariosForo);
    }

    @DeleteMapping("/comentario_foro/{id_comentario_foro}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public int delete(@PathVariable int id_comentario_foro){
        return comentariosForoService.delete(id_comentario_foro);
    }
}
