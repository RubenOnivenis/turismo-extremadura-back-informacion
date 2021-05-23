package com.backend.models.services;

import com.backend.models.dao.ComentariosForoDao;
import com.backend.models.entity.ComentariosForo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentariosForoServcieImpl implements ComentariosForoService{

    @Autowired
    private ComentariosForoDao comentariosForoDao;

    @Override
    public List<ComentariosForo> findAll() {
        return comentariosForoDao.getComentariosForo();
    }

    @Override
    public ComentariosForo findById(int idComentarioForo) {
        return comentariosForoDao.getComentariosForoById(idComentarioForo);
    }
}
