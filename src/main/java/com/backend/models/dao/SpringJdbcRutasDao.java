package com.backend.models.dao;

import com.backend.models.entity.Rutas;
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
public class SpringJdbcRutasDao extends JdbcDaoSupport implements RutasDao {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private NamedParameterJdbcTemplate getNamedJdbcTemplate(){

        if (this.namedParameterJdbcTemplate == null){

            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        }
        return this.namedParameterJdbcTemplate;
    }

    @Override
    public List<Rutas> getRuta() {
        String sql = "SELECT * FROM rutas r;";

        return getJdbcTemplate().query(sql, new SpringJdbcRutasDao.RutasRowMapper());
    }

    @Override
    public List<Rutas> getRutasByName(String nombre) {
        String sql = "SELECT r.imagen, r.nombre, l.nombre, r.descripcion FROM rutas r INNER JOIN localizaciones l " +
                "ON r.id_localizacion = l.id_localizacion WHERE r.nombre = :nombre OR l.nombre = :nombre;";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre", nombre);

        return getNamedJdbcTemplate().query(sql, params, new SpringJdbcRutasDao.RutasRowMapper());
    }

    private class RutasRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            Rutas rutas = new Rutas();

            rutas.setIdRuta(rs.getInt("id_ruta"));
            rutas.setIdLocalizacion(rs.getInt("id_localizacion"));
            rutas.setImagen(rs.getString("imagen"));
            rutas.setNombre(rs.getString("nombre"));
            rutas.setDescripcion(rs.getString("descripcion"));
            rutas.setUrl(rs.getString("url"));

            return rutas;

        }

    }
}
