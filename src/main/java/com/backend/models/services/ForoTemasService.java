package com.backend.models.services;

import com.backend.models.entity.ForoTemas;

import java.util.List;

public interface ForoTemasService {

    List<ForoTemas> findAll();

    ForoTemas findById(int idTema);

    int save(ForoTemas foroTemas);

    int delete(int idTema, int idUsuario);

    int insert (ForoTemas foroTemas);

    int update (ForoTemas foroTemas);

}
