package com.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.dao.UsuarioDao;
import com.backend.models.entity.Usuario;

/** Anotacion para indicar que esta clase es un servicio **/
@Service
/** Clase a la que le se le implementa las funcionalidades de UsuarioService **/
public class UsuarioServiceImpl implements UsuarioService{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable de tipo usuarioDao **/
    private UsuarioDao usuarioDao;

    @Override
    /** Funcion de tipo lista del obj Usuario, proveniente de la interfaz **/
    public List<Usuario> findAll() {
        return usuarioDao.getUsuarios();
    }

    @Override
    /** Funcion de tipo de tipo int, se le pasa la variable int id, proviene de la interfaz **/
    public int delete(int id) {
        return usuarioDao.delete(id);
    }

    @Override
    /** Funcion de tipo lista del obj Usuario, se le pasa la variable Strin nombre_usuario y proveniente de la interfaz **/
    public Usuario findByName(String nombre_usuario) {
        return usuarioDao.getUsuarioByName(nombre_usuario);
    }

    @Override
    /** Funciion de tipo int, se le pasa el obj usuario y proviene de la interfaz **/
    public int update(Usuario usuario) {
        return usuarioDao.update(usuario);
    }

    @Override
    /** Funciion de tipo int, se le pasa el obj usuario y proviene de la interfaz **/
    public int updatePass(Usuario usuario) {
        return usuarioDao.updatePass(usuario);
    }
}
