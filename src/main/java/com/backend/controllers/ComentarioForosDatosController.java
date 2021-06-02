package com.backend.controllers;

import com.backend.models.entity.ComentariosForoDatos;
import com.backend.models.services.ComentariosForoDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ComentarioForosDatosController {

    @Autowired
    ComentariosForoDatosService comentariosForoDatosService;

    @GetMapping("/comentarios_foro_datos")
    public List<ComentariosForoDatos> findAll(){
        return comentariosForoDatosService.findAll();
    }

    @GetMapping("/comentarios_foro_datos/{idTema}")
    public List<ComentariosForoDatos> show(@PathVariable int idTema){
        return comentariosForoDatosService.findById(idTema);
    }
}
