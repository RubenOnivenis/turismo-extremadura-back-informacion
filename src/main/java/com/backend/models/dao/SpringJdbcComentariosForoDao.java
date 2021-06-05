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

@Repository
public class SpringJdbcComentariosForoDao extends JdbcDaoSupport implements ComentariosForoDao{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<ComentariosForo> getComentariosForo() {

        String sql = "SELECT * FROM comentarios_foro";

        return getJdbcTemplate().query(sql, new ComentariosForoRowMapper());
    }

    @Override
    public ComentariosForo getComentariosForoById(int idComentarioForo) {

        String sql = "SELECT * FROM foro_temas WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comentario_foro", idComentarioForo);

        return (ComentariosForo) getNamedJdbcTemplate().queryForObject(sql, params, new ComentariosForoRowMapper());
    }

    @Override
    public int insert(ComentariosForo comentariosForo) {
        String sql = "INSERT INTO comentarios_foro(comentario, id_usuario, id_tema, fch_hora_comentario) " +
                "VALUES (:comentario, :id_usuario, :id_tema, :fch_hora_comentario) ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_usuario", comentariosForo.getIdUsuario());
        params.addValue("id_tema", comentariosForo.getIdTema());
        params.addValue("fch_hora_comentario", comentariosForo.getFchHoraComentario());
        
        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int update(ComentariosForo comentariosForo) {

        String sql = "UPDATE comentarios_foro SET comentario = :comentario WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("comentario", comentariosForo.getComentario());
        params.addValue("id_comentario_foro", comentariosForo.getIdComentarioForo());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    public int delete(int idComentarioForo) {

        String sql = "DELETE FROM comentarios_foro WHERE id_comentario_foro = :id_comentario_foro";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comentario_foro", idComentarioForo);

        return getNamedJdbcTemplate().update(sql, params);
    }

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    private class ComentariosForoRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

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
