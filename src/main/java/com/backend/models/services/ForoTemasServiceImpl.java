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

    @Override
    public int save(ForoTemas foroTemas) {
        return foroTemasDao.insert(foroTemas);
    }

    @Override
    public int delete(int idTema) {
        return foroTemasDao.delete(idTema);
    }

    @Override
    public int insert(ForoTemas foroTemas) {
        return foroTemasDao.update(foroTemas);
    }

    @Override
    public int update(ForoTemas foroTemas) {
        return foroTemasDao.update(foroTemas);
    }
}
