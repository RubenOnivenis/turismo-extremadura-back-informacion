package com.backend.models.services;

import com.backend.models.entity.ComentariosForo;

import java.util.List;

public interface ComentariosForoService {

    List<ComentariosForo> findAll();

    ComentariosForo findById(int idComentarioForo);

    int save(ComentariosForo comentariosForo);

    int delete(int idComentarioForo);

    int insert (ComentariosForo comentariosForo);

    int update (ComentariosForo comentariosForo);

}
