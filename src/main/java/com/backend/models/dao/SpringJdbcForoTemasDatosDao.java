package com.backend.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.backend.models.entity.ForoTemas;
import com.backend.models.entity.ForoTemasDatos;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcForoTemasDatosDao extends JdbcDaoSupport implements ForoTemasDatosDao {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ForoTemasDatos> getForoTemasDatos() {

        String sql = "SELECT foro_temas.id_tema, foro_temas.nombre_tema, foro_temas.comentario_tema, foro_temas.id_usuario, foro_temas.fch_hora_tema, usuario.nombre_usuario "
        		+ "FROM foro_temas INNER JOIN usuario ON foro_temas.id_usuario = usuario.id";

        return getJdbcTemplate().query(sql, new ForoTemasDatosRowMapper());
    }

    @Override
    public ForoTemasDatos getForoTemasDatosById(int id_tema) {

    	String sql = "SELECT foro_temas.id_tema, foro_temas.nombre_tema, foro_temas.comentario_tema, foro_temas.id_usuario, foro_temas.fch_hora_tema, usuario.nombre_usuario "
    			+ "FROM foro_temas INNER JOIN usuario ON foro_temas.id_usuario = usuario.id "
    			+ "WHERE id_tema = :id_tema";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_tema", id_tema);

        return (ForoTemasDatos) getNamedJdbcTemplate().queryForObject(sql, params, new ForoTemasDatosRowMapper());
    }
    
    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class ForoTemasDatosRowMapper implements RowMapper{

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            ForoTemasDatos foroTemasDatos = new ForoTemasDatos();

            foroTemasDatos.setId_tema(rs.getInt("id_tema"));
            foroTemasDatos.setNombre_tema(rs.getString("nombre_tema"));
            foroTemasDatos.setComentario_tema(rs.getString("comentario_tema"));
            foroTemasDatos.setId_usuario(rs.getInt("id_usuario"));
            foroTemasDatos.setFch_hora_tema(rs.getDate("fch_hora_tema"));
            foroTemasDatos.setNombre_usuario(rs.getString("nombre_usuario"));

            return foroTemasDatos;

        }

    }
}
