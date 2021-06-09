package com.backend.models.dao;

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
/** Extiende de JdbcDaoSupport e implementa el Dao de Localizaciones **/
public class SpringJdbcLocalizacionesDao extends JdbcDaoSupport implements LocalizacionesDao {

	/** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /** Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /** Metodo de tipo Lista del obj Localizaciones, que realiza una consulta
     * La consulta trae todos los datos de las Localizaciones
     * **/
    public List<Localizaciones> getLocalizaciones(){

        String sql = "SELECT * FROM  localizaciones";
        return getJdbcTemplate().query(sql, new localizacionesRowMapper());

    }
    
    @Override
    /** Metodo de tipo Lista del obj Localizaciones, que realiza una consulta
     * La consulta trae todos los datos de las Localizaciones buscando por el nombre de la Localizacion
     * **/
	public List<Localizaciones> getLocalizacionesByNombre(String nombre) {
		// TODO Auto-generated method stub
		String SQL="SELECT * FROM localizaciones WHERE nombre LIKE CONCAT('%',:nombre,'%');";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre", nombre);
		return getNamedJdbcTemplate().query(SQL, params, new localizacionesRowMapper());
	}
	

    private NamedParameterJdbcTemplate getNamedJdbcTemplate() {

        if (this.namedParameterJdbcTemplate == null) {

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }

        return this.namedParameterJdbcTemplate;

    }

    /** Clase a al que le implementamos las funcionalidades de RowMapper
     * Asigna valores a los datos de la bbdd
     * **/
    private class localizacionesRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException{

            Localizaciones localizaciones = new Localizaciones();

            localizaciones.setIdLocalizacion(rs.getInt("id_localizacion"));
            localizaciones.setNombre(rs.getString("nombre"));
            localizaciones.setProvincia(rs.getString("provincia"));
            localizaciones.setComarca(rs.getString("comarca"));
            localizaciones.setImagen(rs.getString("imagen"));
            localizaciones.setUrl(rs.getString("url"));

            return localizaciones;

        }

    }

}
