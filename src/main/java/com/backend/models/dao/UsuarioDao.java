package com.backend.models.dao;


import java.util.List;

import com.backend.models.entity.Usuario;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario getUsuarioById(String nombre_usuario);

    int delete(int id);

    int update(Usuario usuario);

    int updatePass(Usuario usuario);
}
