package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;

import java.util.List;

public interface ComentariosForoDao {

    List<ComentariosForo> getComentariosForo();

    ComentariosForo getComentariosForoById(int idComentarioForo);

    int insert(ComentariosForo comentariosForo);

    int update(ComentariosForo comentariosForo);

    int delete(int idComentarioForo, int idUsuario);
}
