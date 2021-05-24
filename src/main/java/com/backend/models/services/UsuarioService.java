package com.backend.models.services;


import java.util.List;

import com.backend.models.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll();

   // public int save(Usuario usuario);

    public int delete(int id);

    public Usuario findById(String nombre_usuario);

   // public int insert(Usuario usuario);

    public int update(Usuario usuario);

    public int updatePass(Usuario usuario);

}
