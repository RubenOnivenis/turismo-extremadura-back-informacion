package com.backend.models.dao;

import com.backend.models.entity.ForoTemas;

import java.util.List;

public interface ForoTemasDao {

    List<ForoTemas> getForoTemas();

    ForoTemas getForoTemasById(int idTema);

}
