package com.backend.models.dao;

import com.backend.models.entity.ForoTemas;
import com.backend.models.entity.Localizaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/** Repository es una anotacion de Spring que indica que la clase decorada es un repositorio.
 * es un mecanismo para encapsular el comportamiento de almacenamiento,
 * recuperación y búsqueda que emula una colección de objetos.
 * **/
@Repository
/** Extiende de JdbcDaoSupport e implementa el Dao de ForoTemas **/
public class SpringJdbcForoTemasDao extends JdbcDaoSupport implements ForoTemasDao {

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable jdbcTemplate de tipo JdbcTemplate **/
    private JdbcTemplate jdbcTemplate;
    /** Variable namedParameterJdbcTemplate de tipo NamedParameterJdbcTemplate **/
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    /**
     * Metodo de tipo lista del obj ForoTemas
     * La consulta se encarga de mostrar todos los temas y sus datos
     **/
    public List<ForoTemas> getForoTemas() {

        String sql = "SELECT * FROM foro_temas";

        return getJdbcTemplate().query(sql, new ForoTemasRowMapper());
    }

    @Override
    /**
     * Metodo de tipo obj ForoTemas se le pasa la variable int idTema
     * La consulta muestra un solo tema, según su id, y todos los datos de ese tema
     **/
    public ForoTemas getForoTemasById(int idTema) {

        String sql = "SELECT * FROM foro_temas WHERE id_tema = :id_tema";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("id_tema", idTema);

        return (ForoTemas) getNamedJdbcTemplate().queryForObject(sql, params, new ForoTemasRowMapper());
    }

    @Override
    /**
     * Metodo de tipo int se le pasa el obj ForoTemas
     * La consulta inserta temas
     * **/
    public int insert(ForoTemas foroTemas) {
        String sql = "INSERT INTO foro_temas(nombre_tema, comentario_tema, id_usuario, fch_hora_tema) " +
                "VALUES (:nombre_tema, :comentario_tema, :id_usuario, :fch_hora_tema) ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("nombre_tema", foroTemas.getNombreTema());
        params.addValue("comentario_tema", foroTemas.getComentarioTema());
        params.addValue("id_usuario", foroTemas.getIdUsuario());
        params.addValue("fch_hora_tema", foroTemas.getFchHoraTema());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /**
     * Metodo de tipo int se le pasa el obj ForoTemas
     * La consulta modifica un tema
     * **/
    public int update(ForoTemas foroTemas) {

        String sql = "UPDATE foro_temas SET nombre_tema = :nombre_tema, comentario_tema = :comentario_tema " +
                "WHERE id_tema = :id_tema AND id_usuario = :id_usuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("id_tema", foroTemas.getIdTema());
        params.addValue("nombre_tema", foroTemas.getNombreTema());
        params.addValue("comentario_tema", foroTemas.getComentarioTema());
        params.addValue("id_usuario", foroTemas.getIdUsuario());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /**
     * Metodo de tipo int se le pasa el obj ForoTemas
     * La consulta borra un tema
     * **/
    public int delete(int idTema) {

        String sql = "DELETE FROM foro_temas WHERE id_tema = :id_tema";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("id_tema", idTema);

        return getNamedJdbcTemplate().update(sql, params);
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    /** Clase a al que le implementamos las funcionalidades de RowMapper
     * Asigna valores a los datos de la bbdd
     * **/
    private class ForoTemasRowMapper implements RowMapper{

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            /** Creamos la variable de tipo obj de comentariosForoDatos igualada a ForoTemas **/
            ForoTemas foroTemas = new ForoTemas();

            foroTemas.setIdTema(rs.getInt("id_tema"));
            foroTemas.setNombreTema(rs.getString("nombre_tema"));
            foroTemas.setComentarioTema(rs.getString("comentario_tema"));
            foroTemas.setIdUsuario(rs.getInt("id_usuario"));
            foroTemas.setFchHoraTema(rs.getDate("fch_hora_tema"));

            return foroTemas;

        }

    }
}
