package com.backend.controllers;

import com.backend.models.entity.ForoTemasDatos;
import com.backend.models.services.ForoTemasDatosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ForoTemasDatosController {

	@Autowired
	ForoTemasDatosService foroTemasDatosService;
	
	@GetMapping("/foro_temas_datos")
    public List<ForoTemasDatos> findAll() {
        return foroTemasDatosService.findAll();
    }
    
	@GetMapping("/foro_temas_datos/{id_tema}")
    public ForoTemasDatos show(@PathVariable int id_tema){
        return foroTemasDatosService.findById(id_tema);
    }
	
	//Controlador para ver los temas según el nombre, este sirve para el buscador
    @GetMapping("/foro_temas_datos/nombre/{nombre}")
	public List<ForoTemasDatos> show(@PathVariable String nombre) {
		return foroTemasDatosService.findByName(nombre);
	}
}
