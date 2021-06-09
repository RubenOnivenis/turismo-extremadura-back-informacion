package com.backend.models.dao;

import com.backend.models.entity.ComentariosForoDatos;
import com.backend.models.entity.ForoTemasDatos;
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
/** Extiende de JdbcDaoSupport e implementa el Dao de ComentarioForoDatos **/
public class SpringJdbcComentariosForoDatosDao extends JdbcDaoSupport implements ComentarioForoDatosDao{

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
     * Metodo de tipo lista del obj ComentariosForoDatos
     * La consulta que realiza muestra los datos de los comentarios, del foro y de los usuarios para que se pueda ver
     * quien realiza el tema, el comentario y que tema es
     **/
    public List<ComentariosForoDatos> getComentariosForoDatos() {

        String sql = "SELECT cf.id_comentario_foro, cf.comentario, cf.id_usuario, cf.id_tema, cf.fch_hora_comentario, " +
                "u.nombre_usuario, ft.nombre_tema, ft.comentario_tema " +
                "FROM comentarios_foro cf INNER JOIN usuario u " +
                "ON cf.id_usuario = u.id " +
                "INNER JOIN foro_temas ft ON cf.id_tema = ft.id_tema";

        return getJdbcTemplate().query(sql, new ComentariosForoDatosRowMapper());
    }

    @Override
    /**
     * Metodo de tipo lista del obj ComentariosForoDatos, se le pasa la variable int idTema
     * La consulta que realiza muestra los datos de los comentarios, del foro y de los usuarios para que se pueda ver
     * quien realiza el tema, el comentario y que tema es
     * se realiza por id para ver uno en concreto
     **/
    public List<ComentariosForoDatos> getComentariosForoDatosById(int idTema) {

        String sql = "SELECT cf.id_comentario_foro, cf.comentario, cf.id_usuario, cf.id_tema, cf.fch_hora_comentario, " +
                "u.nombre_usuario, ft.nombre_tema, ft.comentario_tema " +
                "FROM comentarios_foro cf INNER JOIN usuario u " +
                "ON cf.id_usuario = u.id " +
                "INNER JOIN foro_temas ft ON cf.id_tema = ft.id_tema " +
                "WHERE ft.id_tema = :id_tema";

        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Las variables se igualan a las que se les pasa **/
        params.addValue("id_tema", idTema);
        return getNamedJdbcTemplate().query(sql, params, new ComentariosForoDatosRowMapper());
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
    private class ComentariosForoDatosRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            /** Creamos la variable de tipo obj de comentariosForoDatos igualada a comentariosForoDatos **/
            ComentariosForoDatos comentariosForoDatos = new ComentariosForoDatos();

            comentariosForoDatos.setIdComentarioForo(rs.getInt("id_comentario_foro"));
            comentariosForoDatos.setComentario(rs.getString("comentario"));
            comentariosForoDatos.setIdUsuario(rs.getInt("id_usuario"));
            comentariosForoDatos.setIdTema(rs.getInt("id_tema"));
            comentariosForoDatos.setFchHoraComentario(rs.getDate("fch_hora_comentario"));
            comentariosForoDatos.setNombreUsuario(rs.getString("nombre_usuario"));
            comentariosForoDatos.setNombreTema(rs.getString("nombre_tema"));
            comentariosForoDatos.setDescripcionTema(rs.getString("comentario_tema"));

            return comentariosForoDatos;

        }

    }
}
