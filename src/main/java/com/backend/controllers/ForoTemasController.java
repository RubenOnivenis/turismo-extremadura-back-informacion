package com.backend.controllers;

import com.backend.models.entity.ForoTemas;
import com.backend.models.services.ForoTemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Anotación que nos indica que es una clase para controladores
@RestController
// Anotación para el mapeo, le indicamos que /api ira al principio
@RequestMapping("/api")
// Lo conectamos con el localhost de angular
@CrossOrigin(origins = {"http://localhost:4200"})
public class ForoTemasController {

    // @Autowired nos permite inyectar la dependencia dentro de otras
    @Autowired private ForoTemasService foroTemasService;

    // Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /temas_foro
    @GetMapping("/temas_foro")
    // Controlador para ver todos los temas del foro
    public List<ForoTemas> foroTemasIndex(){
        return foroTemasService.findAll();
    }

    // Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /temas_foro{id_tema}
    @GetMapping("/temas_foro/{id_tema}")
    // Controlador para ver un solo tema del foro
    // Con @PathVariable configuramos la variable dentro del propio segmento de la URL
    public ForoTemas show(@PathVariable int id_tema){
        return foroTemasService.findById(id_tema);
    }

    // Anotación con la cual que indicamos que es una petición post y en el endpoint se escribirá /temas_foro
    @PostMapping("/temas_foro")
    // Anotación que nos permite marcar el método con el código httm y la razon con la que es devuelto, en este caso es CREATED
    @ResponseStatus(HttpStatus.CREATED)
    // Controlador para añadir un tema al foro
    // Con @RequestBody le pasamos el cuerpo entero del obj
    public int create (@RequestBody ForoTemas foroTemas){
        return foroTemasService.save(foroTemas);
    }

    // Anotación con la cual que indicamos que es una petición put y en el endpoint se escribirá /comentario_foro/{id_comentario_foro}
    @PutMapping("/temas_foro/{id_tema}")
    // Controlador para modificar un tema del foro
    // Con @RequestBody le pasamos el cuerpo entero del obj
    // Con @PathVariable configuramos la variable dentro del propio segmento de la URL
    public int update(@RequestBody ForoTemas foroTemas, @PathVariable int id_tema){
        foroTemas.setIdTema(id_tema);
        return foroTemasService.update(foroTemas);
    }

    // Anotación con la cual que indicamos que es una petición delete y en el endpoint se escribirá /temas_foro/{id_tema}
    @DeleteMapping("/temas_foro/{id_tema}")
    // Anotación que nos permite marcar el método con el código httm y la razon con la que es devuelto, en este caso es DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // Controlador para borrar un tema del foro
    // Con @PathVariable configuramos la variable dentro del propio segmento de la URL
    public int delete(@PathVariable int id_tema){
        return foroTemasService.delete(id_tema);
    }
}
