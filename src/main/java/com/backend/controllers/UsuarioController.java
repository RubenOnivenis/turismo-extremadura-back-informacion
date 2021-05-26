package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.backend.models.entity.Usuario;
import com.backend.models.services.UsuarioService;

import java.util.List;

@RestController @RequestMapping("/api") @CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")	//Todos los usuarios
    public List<Usuario> usuariosIndex(){

        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{nombre_usuario}")	//Usuarios por id
    public Usuario show(@PathVariable String nombre_usuario) {

        return usuarioService.findByName(nombre_usuario);
    }

    @PutMapping("/usuarios/{nombre_usuario}") @ResponseStatus(HttpStatus.CREATED)	//Modificar usuario, menos la contraseña
    public int update(@RequestBody Usuario usuario, @PathVariable int id) {

        usuario.setId(id);

        return usuarioService.update(usuario);
    }

    @DeleteMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public int delete(@PathVariable int id) {

        return usuarioService.delete(id);
    }

    @PutMapping("/usuarios/pass/{nombre_usuario}") @ResponseStatus(HttpStatus.CREATED)	//Modificar contraseña del usuario
    public int updatePass(@RequestBody Usuario usuario, @PathVariable int id) {

        usuario.setId(id);

        return usuarioService.updatePass(usuario);
    }

}
