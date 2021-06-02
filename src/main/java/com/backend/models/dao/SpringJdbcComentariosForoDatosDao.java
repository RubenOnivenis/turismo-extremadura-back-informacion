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

@Repository
public class SpringJdbcComentariosForoDatosDao extends JdbcDaoSupport implements ComentarioForoDatosDao{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ComentariosForoDatos> getComentariosForoDatos() {

        String sql = "SELECT cf.id_comentario_foro, cf.comentario, cf.id_usuario, cf.id_tema, cf.fch_hora_comentario, " +
                "u.nombre_usuario, ft.nombre_tema, ft.comentario_tema " +
                "FROM comentarios_foro cf INNER JOIN usuario u " +
                "ON cf.id_usuario = u.id " +
                "INNER JOIN foro_temas ft ON cf.id_tema = ft.id_tema";

        return getJdbcTemplate().query(sql, new ComentariosForoDatosRowMapper());
    }

    @Override
    public List<ComentariosForoDatos> getComentariosForoDatosById(int idTema) {

        String sql = "SELECT cf.id_comentario_foro, cf.comentario, cf.id_usuario, cf.id_tema, cf.fch_hora_comentario, " +
                "u.nombre_usuario, ft.nombre_tema, ft.comentario_tema " +
                "FROM comentarios_foro cf INNER JOIN usuario u " +
                "ON cf.id_usuario = u.id " +
                "INNER JOIN foro_temas ft ON cf.id_tema = ft.id_tema " +
                "WHERE ft.id_tema = :id_tema";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_tema", idTema);
        return getNamedJdbcTemplate().query(sql, params, new ComentariosForoDatosRowMapper());
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class ComentariosForoDatosRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

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
