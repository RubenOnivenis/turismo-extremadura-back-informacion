package com.backend.models.services;

import com.backend.models.dao.ForoTemasDao;
import com.backend.models.entity.ForoTemas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForoTemasServiceImpl implements ForoTemasService{

    @Autowired private ForoTemasDao foroTemasDao;

    @Override
    public List<ForoTemas> findAll() {
        return foroTemasDao.getForoTemas();
    }

    @Override
    public ForoTemas findById(int idTema) {
        return foroTemasDao.getForoTemasById(idTema);
    }


}
