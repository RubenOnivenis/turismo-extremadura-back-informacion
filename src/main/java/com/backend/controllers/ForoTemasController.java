package com.backend.controllers;

import com.backend.models.entity.ForoTemas;
import com.backend.models.services.ForoTemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ForoTemasController {

    @Autowired private ForoTemasService foroTemasService;

    @GetMapping("/temas_foro")
    public List<ForoTemas> foroTemasIndex(){
        return foroTemasService.findAll();
    }

    @GetMapping("/temas_foro/{id_tema}")
    public ForoTemas show(@PathVariable int id_tema){
        return foroTemasService.findById(id_tema);
    }


}
