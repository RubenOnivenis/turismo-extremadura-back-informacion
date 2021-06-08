package com.backend.models.dao;


import java.util.List;

import com.backend.models.entity.Usuario;

public interface UsuarioDao {

    /** Método de tipo lista del obj Usuario **/
    List<Usuario> getUsuarios();

    /** Método de tipo obj Usuario al que se le pasa la variable Strin nombre_usuario **/
    Usuario getUsuarioByName(String nombre_usuario);

    /** Método de tipo int al que se le pasa la variable int id **/
    int delete(int id);

    /** Método de tipo int al que se le pasa el obj Usuario **/
    int update(Usuario usuario);

    /** Método de tipo int al que se le pasa el obj Usuario **/
    int updatePass(Usuario usuario);
}
