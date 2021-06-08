package com.backend.controllers;

import com.backend.models.entity.ForoTemasDatos;
import com.backend.models.services.ForoTemasDatosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Anotación que nos indica que es una clase para controladores **/
@RestController
/** Anotación para el mapeo, le indicamos que /api ira al principio**/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular**/
@CrossOrigin(origins = {"http://localhost:4200"})
public class ForoTemasDatosController {

	/** @Autowired nos permite inyectar la dependencia dentro de otras**/
	@Autowired
	/** Servicio de foroTemasDatos**/
	ForoTemasDatosService foroTemasDatosService;

	/** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /foro_temas_datos**/
	@GetMapping("/foro_temas_datos")
	/** Controlador que sirve para mostrar todos los temas del foro**/
    public List<ForoTemasDatos> findAll() {
        return foroTemasDatosService.findAll();
    }

	/** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /foro_temas_datos/{id_tema}**/
	@GetMapping("/foro_temas_datos/{id_tema}")
	/** Controlador que sirve para mostrar un solo tema del foro según el id_tema**/
	/** Con @PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public ForoTemasDatos show(@PathVariable int id_tema){
        return foroTemasDatosService.findById(id_tema);
    }

	/** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /foro_temas_datos/nombre/{nombre}**/
    @GetMapping("/foro_temas_datos/nombre/{nombre}")
	/** Controlador para ver los temas según el nombre, este sirve para el buscador**/
	/** Con @PathVariable configuramos la variable dentro del propio segmento de la URL**/
	public List<ForoTemasDatos> show(@PathVariable String nombre) {
		return foroTemasDatosService.findByName(nombre);
	}
}
