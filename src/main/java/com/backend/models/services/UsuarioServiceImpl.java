package com.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.dao.UsuarioDao;
import com.backend.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.getUsuarios();
    }

   /* @Override
    public int save(Usuario usuario) {
        return usuarioDao.insert(usuario);
    }*/

    @Override
    public int delete(int id) {
        return usuarioDao.delete(id);
    }

    @Override
    public Usuario findById(String nombre_usuario) {
        return usuarioDao.getUsuarioById(nombre_usuario);
    }

   /* @Override
    public int insert(Usuario usuario) {
        return usuarioDao.insert(usuario);
    }*/

    @Override
    public int update(Usuario usuario) {
        return usuarioDao.update(usuario);
    }

    @Override
    public int updatePass(Usuario usuario) {
        return usuarioDao.updatePass(usuario);
    }
}
