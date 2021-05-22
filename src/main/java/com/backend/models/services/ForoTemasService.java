package com.backend.models.services;

import com.backend.models.entity.ForoTemas;

import java.util.List;

public interface ForoTemasService {

    List<ForoTemas> findAll();

    ForoTemas findById(int idTema);

}
