package com.backend.models.services;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.entity.ForoTemas;

import java.util.List;

public interface ComentariosForoService {

    List<ComentariosForo> findAll();

    ComentariosForo findById(int idComentarioForo);

}
