package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.backend.models.entity.Usuario;
import com.backend.models.services.UsuarioService;

import java.util.List;

/** Anotación que nos indica que es una clase para controladores **/
@RestController
/** Anotación para el mapeo, le indicamos que /api ira al principio **/
@RequestMapping("/api")
/** Lo conectamos con el localhost de angular**/
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {

    /** Autowired nos permite inyectar la dependencia dentro de otras**/
    @Autowired
    /** Servicio de los usuarios**/
    private UsuarioService usuarioService;

    /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /usuarios**/
    @GetMapping("/usuarios")
    /**Controlador que sirve para mostrar todos los usuarios**/
    public List<Usuario> usuariosIndex(){

        return usuarioService.findAll();
    }

    /** Anotación con la cual indicamos que es una petición de tipo GET y en el endpoint se escribirá /usuarios/{nombre_usuario}**/
    @GetMapping("/usuario/{nombre_usuario}")
    /** Controlador que sirve para mostrar el usuario pro el nombre de usuario**/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public Usuario show(@PathVariable String nombre_usuario) {

        return usuarioService.findByName(nombre_usuario);
    }

    /** Anotación con la cual indicamos que es una petición de tipo PUT y en el endpoint se escribirá /usuarios/{nombre_usuario}**/
    @PutMapping("/usuarios/{nombre_usuario}") @ResponseStatus(HttpStatus.CREATED)
    /** Controlador que sirve para modificar los datos del usuario menos la contraseña**/
    /** Con RequestBody le pasamos el cuerpo entero del obj**/
    /**Con PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public int update(@RequestBody Usuario usuario, @PathVariable String nombre_usuario) {

        usuario.setNombreUsuario(nombre_usuario);

        return usuarioService.update(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    /**Anotación que nos permite marcar el método con el código httm y la razon con la que es devuelto, en este caso es DELETE**/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**Controlador que sirve para borrar un usuario**/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public int delete(@PathVariable int id) {

        return usuarioService.delete(id);
    }

    @PutMapping("/usuarios/pass/{nombre_usuario}")
    /** Anotación que nos permite marcar el método con el código httm y la razon con la que es devuelto, en este caso es CREATED**/
    @ResponseStatus(HttpStatus.CREATED)
    /** Controlador que sirve para modificar la contraseña del usuario**/
    /** Con RequestBody le pasamos el cuerpo entero del obj**/
    /** Con PathVariable configuramos la variable dentro del propio segmento de la URL**/
    public int updatePass(@RequestBody Usuario usuario, @PathVariable int id) {

        usuario.setId(id);

        return usuarioService.updatePass(usuario);
    }

}
