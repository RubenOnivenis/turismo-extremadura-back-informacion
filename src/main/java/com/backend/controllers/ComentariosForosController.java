package com.backend.controllers;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.services.ComentariosForoService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
