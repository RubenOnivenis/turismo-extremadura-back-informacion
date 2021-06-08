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

/** @Repository es una anotacion de Spring que indica que la clase decorada es un repositorio.
 * es un mecanismo para encapsular el comportamiento de almacenamiento,
 * recuperación y búsqueda que emula una colección de objetos.
 * **/
@Repository
/** Extiende de JdbcDaoSupport e implementa el Dao de ForoTemasDatos **/
public class SpringJdbcForoTemasDatosDao extends JdbcDaoSupport implements ForoTemasDatosDao {

	/** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    
    @Override
    /** Metodo de tipo Lista del obj ForoTemasDatos, que realiza una consulta
     * La consulta trae todos los datos de los Temas del foro
     * **/
    public List<ForoTemasDatos> getForoTemasDatos() {

        String sql = "SELECT foro_temas.id_tema, foro_temas.nombre_tema, foro_temas.comentario_tema, foro_temas.id_usuario, "
                + "foro_temas.fch_hora_tema, usuario.nombre_usuario "
        		+ "FROM foro_temas INNER JOIN usuario ON foro_temas.id_usuario = usuario.id";

        return getJdbcTemplate().query(sql, new ForoTemasDatosRowMapper());
    }

    @Override
    /** Metodo del obj ForoTemasDatos, que realiza una consulta
     * La consulta trae todos los datos de un Tema por su id
     * **/
    public ForoTemasDatos getForoTemasDatosById(int id_tema) {

    	String sql = "SELECT foro_temas.id_tema, foro_temas.nombre_tema, foro_temas.comentario_tema, foro_temas.id_usuario, foro_temas.fch_hora_tema, usuario.nombre_usuario "
    			+ "FROM foro_temas INNER JOIN usuario ON foro_temas.id_usuario = usuario.id "
    			+ "WHERE id_tema = :id_tema";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_tema", id_tema);

        return (ForoTemasDatos) getNamedJdbcTemplate().queryForObject(sql, params, new ForoTemasDatosRowMapper());
    }
    
    @Override
    /** Metodo de tipo Lista del obj ForoTemasDatos, que realiza una consulta
     * La consulta trae todos los datos de los Temas del foro buscando por el nombre del Tema
     * **/
	public List<ForoTemasDatos> getTemasByNombre(String nombre) {
		// TODO Auto-generated method stub
		String SQL="SELECT foro_temas.id_tema, foro_temas.nombre_tema, foro_temas.comentario_tema, foro_temas.id_usuario, foro_temas.fch_hora_tema, usuario.nombre_usuario "
				+ "FROM foro_temas INNER JOIN usuario ON foro_temas.id_usuario = usuario.id "
				+ "WHERE nombre_tema LIKE CONCAT('%',:nombre,'%');";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre", nombre);
		return getNamedJdbcTemplate().query(SQL, params, new ForoTemasDatosRowMapper());
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
