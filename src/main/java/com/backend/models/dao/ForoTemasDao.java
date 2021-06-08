package com.backend.models.dao;

import com.backend.models.entity.ForoTemas;

import java.util.List;

public interface ForoTemasDao {

    /** Metodo tipo Lista del obj ForoTemas **/
    List<ForoTemas> getForoTemas();

    /** Metodo tipo obj ForoTemas al que se le pasa la variable int idTema **/
    ForoTemas getForoTemasById(int idTema);

    /** Metodo tipo int al que se le pasa el obj ForoTemas **/
    int insert(ForoTemas foroTemas);

    /** Metodo tipo int al que se le pasa el obj ForoTemas **/
    int update(ForoTemas foroTemas);

    /** Metodo tipo int al que se le pasa la variable int idTema **/
    int delete(int idTema);

}
