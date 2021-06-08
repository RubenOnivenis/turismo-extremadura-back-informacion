package com.backend.models.dao;

import com.backend.models.entity.ComentariosForo;
import com.backend.models.entity.ForoTemas;
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

/** @Repository es una anotacion de Spring que indica que la clase decorada es un repositorio.
 * es un mecanismo para encapsular el comportamiento de almacenamiento,
 * recuperación y búsqueda que emula una colección de objetos.
 * **/
@Repository
/** Extiende de JdbcDaoSupport e implementa el Dao de ComentariosForo **/
public class SpringJdbcComentariosForoDao extends JdbcDaoSupport implements ComentariosForoDao{

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    /** Variable jdbcTemplate de tipo JdbcTemplate **/
    private JdbcTemplate jdbcTemplate;
    /** Variable namedParameterJdbcTemplate de tipo NamedParameterJdbcTemplate **/
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    /**
     * Metodo de tipo lista del obj ComentariosForo que realiza una consulta
     * La consulta trae todos los datos de los comentarios del foro
     **/
    public List<ComentariosForo> getComentariosForo() {

        String sql = "SELECT * FROM comentarios_foro";

        return getJdbcTemplate().query(sql, new ComentariosForoRowMapper());
    }

    @Override
    /**
     * Metodo de tipo obj ComentariosForo al cual se le pasa la variable int idComentarioForo
     * Realiza una consulta que trae todos los datos del comentario según su id
     *  **/
    public ComentariosForo getComentariosForoById(int idComentarioForo) {

        String sql = "SELECT * FROM foro_temas WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** El id del comentario del foro se iguala al seleccionado **/
        params.addValue("id_comentario_foro", idComentarioForo);

        return (ComentariosForo) getNamedJdbcTemplate().queryForObject(sql, params, new ComentariosForoRowMapper());
    }

    @Override
    /**
     * Metodo de tipo int al que se le pasa el obj ComentariosForo
     * Realiza una consulta para insertar un comentario en el foro
     **/
    public int insert(ComentariosForo comentariosForo) {
        String sql = "INSERT INTO comentarios_foro(comentario, id_usuario, id_tema, fch_hora_comentario) " +
                "VALUES (:comentario, :id_usuario, :id_tema, :fch_hora_comentario) ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_usuario", comentariosForo.getIdUsuario());
        params.addValue("id_tema", comentariosForo.getIdTema());
        params.addValue("fch_hora_comentario", comentariosForo.getFchHoraComentario());
        
        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /**
     * Metodo de tipo int al que le pasamos el obj comentariosForo
     * Realiza una consulta para modificar un comentario del foro según su id
     **/
    public int update(ComentariosForo comentariosForo) {

        String sql = "UPDATE comentarios_foro SET comentario = :comentario WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_comentario_foro", comentariosForo.getIdComentarioForo());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /**
     * Metodo de tipo int al que se le pasa la variable int idComentarioForo
     * Realiza una consulta para borrar un comentario del foro segun su id
     **/
    public int delete(int idComentarioForo) {

        String sql = "DELETE FROM comentarios_foro WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("id_comentario_foro", idComentarioForo);

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
    private class ComentariosForoRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            /** Creamos la variable de tipo obj de comentariosForo igualada a comentariosForo **/
            ComentariosForo comentariosForo = new ComentariosForo();

            comentariosForo.setIdComentarioForo(rs.getInt("id_comentario_foro"));
            comentariosForo.setComentario(rs.getString("comentario"));
            comentariosForo.setIdUsuario(rs.getInt("id_usuario"));
            comentariosForo.setIdTema(rs.getInt("id_tema"));
            comentariosForo.setFchHoraComentario(rs.getDate("fch_hora_comentario"));

            return comentariosForo;

        }

    }
}
