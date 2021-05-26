package com.backend.models.services;


import java.util.List;

import com.backend.models.entity.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();

    int delete(int id);

    Usuario findByName(String nombre_usuario);

    int update(Usuario usuario);

    int updatePass(Usuario usuario);

}
