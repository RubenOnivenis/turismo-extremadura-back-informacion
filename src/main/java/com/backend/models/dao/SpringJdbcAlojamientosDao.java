package com.backend.models.dao;

import com.backend.models.entity.Alojamientos;
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
/** Extiende de JdbcDaoSupport e implementa el Dao de alojamientos **/
public class SpringJdbcAlojamientosDao extends JdbcDaoSupport implements AlojamientosDao {

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

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    @Override
    /** Metodo tipo lista del obj Alojamientos que realiza la consulta para mostrar todos los datos de los alojamientos **/
    public List<Alojamientos> getAlojamientos() {
        String sql = "SELECT * FROM alojamientos a;";

        return getJdbcTemplate().query(sql, new SpringJdbcAlojamientosDao.AlojamientosRowMapper());
    }

    @Override
    /** Metodo tipo lista del obj Alojamientos que realiza una consulta de los datos por el nombre del alojamiento o por el nombre de la localizacion **/
    public List<Alojamientos> getAlojamientosByName(String nombre) {

        String sql = "SELECT a.imagen, a.nombre, l.nombre, a.descripcion FROM alojamientos a INNER JOIN localizaciones l " +
                "ON a.id_localizacion = l.id_localizacion WHERE a.nombre = :nombre OR l.nombre = :nombre;";

        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Le decimos que la variable sea igual a la que escribimos **/
        params.addValue("nombre", nombre);

        return getNamedJdbcTemplate().query(sql, params, new AlojamientosRowMapper());
    }

    @Override
    /** Metodo de tipo Alojamientos al que le pasamos la variable int id_alojamiento
     * Muestra todos los datos de los alojamientos segun el id de este
     * **/
    public Alojamientos getAlojamientoById(int id_alojamiento) {

        String sql = "SELECT * FROM alojamientos WHERE id_alojamiento = :id_alojamiento";

        MapSqlParameterSource params = new MapSqlParameterSource();
        /** Le decimos que la variable sea igual a la que escribimos **/
        params.addValue("id_alojamiento", id_alojamiento);

        return (Alojamientos) getNamedJdbcTemplate().queryForObject(sql, params, new AlojamientosRowMapper());

    }

    /** Clase a al que le implementamos las funcionalidades de RowMapper
     * Asigna valores a los datos de la bbdd
     * **/
    private class AlojamientosRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            /** Creamos la variable de tipo obj de Alojamientos igualada a Alojamientos **/
            Alojamientos alojamientos = new Alojamientos();

            alojamientos.setIdAlojamiento(rs.getInt("id_alojamiento"));
            alojamientos.setIdLocalizacion(rs.getInt("id_localizacion"));
            alojamientos.setImagen(rs.getString("imagen"));
            alojamientos.setNombre(rs.getString("nombre"));
            alojamientos.setDescripcion(rs.getString("descripcion"));
            alojamientos.setUrl(rs.getString("url"));

            return alojamientos;

        }

    }

}
