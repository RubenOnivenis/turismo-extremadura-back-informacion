package com.backend.models.services;

import com.backend.models.dao.RutasDao;
import com.backend.models.entity.Alojamientos;
import com.backend.models.entity.Rutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasServiceImpl implements RutasService{

    @Autowired
    private RutasDao rutasDao;

    public List<Rutas> findAll() {
        return rutasDao.getRuta();
    }

    @Override
    public List<Rutas> getRutasByName(String nombre) {
        return rutasDao.getRutasByName(nombre);
    }

}
