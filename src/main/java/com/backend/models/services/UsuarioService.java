package com.backend.models.services;


import java.util.List;

import com.backend.models.entity.Usuario;

/** Interfaz del servicio Usuario **/
public interface UsuarioService {

    /** Funcion tipo lista del obj Usuario **/
    List<Usuario> findAll();

    /** Funcion tipo int se le pasa la variable tipo int id **/
    int delete(int id);

    /** Funcion tipo obj Usuario se le pasa la variable String nombre_usuario **/
    Usuario findByName(String nombre_usuario);

    /** Funcion tipo int se le pasa la variable tipo int id **/
    int update(Usuario usuario);

    /** Funcion tipo int se le pasa la variable tipo int id **/
    int updatePass(Usuario usuario);

}
