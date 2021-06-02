package com.backend.models.services;

import com.backend.models.dao.ComentarioForoDatosDao;
import com.backend.models.entity.ComentariosForoDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioForoDatosImpl implements ComentariosForoDatosService{

    @Autowired private ComentarioForoDatosDao comentarioForoDatosDao;


    @Override
    public List<ComentariosForoDatos> findAll() {
        return comentarioForoDatosDao.getComentariosForoDatos();
    }

    @Override
    public List<ComentariosForoDatos> findById(int idTema) {
        return comentarioForoDatosDao.getComentariosForoDatosById(idTema);
    }
}
