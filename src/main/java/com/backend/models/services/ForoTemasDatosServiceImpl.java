package com.backend.models.services;

import com.backend.models.dao.ForoTemasDatosDao;
import com.backend.models.entity.ForoTemasDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForoTemasDatosServiceImpl implements ForoTemasDatosService{

    @Autowired private ForoTemasDatosDao foroTemasDatosDao;

    @Override
    public List<ForoTemasDatos> findAll() {
        return foroTemasDatosDao.getForoTemasDatos();
    }

    @Override
    public ForoTemasDatos findById(int idTema) {
        return foroTemasDatosDao.getForoTemasDatosById(idTema);
    }
}
