package com.backend.models.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.backend.models.entity.Usuario;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/** @Repository es una anotacion de Spring que indica que la clase decorada es un repositorio.
 * es un mecanismo para encapsular el comportamiento de almacenamiento,
 * recuperación y búsqueda que emula una colección de objetos.
 * **/
@Repository
/** Extiende de JdbcDaoSupport e implementa el Dao de Usuario **/
public class SpringJdbcUsuarioDao extends JdbcDaoSupport implements UsuarioDao{

	/** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    /** @Autowired nos permite inyectar la dependencia dentro de otras **/
    @Autowired private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    /** Metodo de tipo Lista del obj Usuario, que realiza una consulta
     * La consulta trae todos los datos de los Usuarios
     * **/
    public List<Usuario> getUsuarios() {
        String sql = "SELECT * FROM usuario;";
        return getJdbcTemplate().query(sql, new UsuarioRowMapper());
    }

    @Override
    /** Metodo del obj Usuario, que realiza una consulta
     * La consulta trae todos los datos de un Usuario por su nombre de usuario
     * **/
    public Usuario getUsuarioByName(String nombre_usuario) {
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = :nombre_usuario;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nombre_usuario", nombre_usuario);	//Cuando se encuentren :nombre_usuario lo cambiara por la variable id que nos llega del método

        return (Usuario) getNamedJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
    }

    @Override
    /** Metodo de tipo int, que realiza una consulta
     * La consulta borra un Usuario por su Id
     * **/
    public int delete(int id) {
        String sql = "DELETE FROM usuario WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /** Metodo de tipo int, que realiza una consulta
     * La consulta actualiza un Usuario por su nombre de usuario
     * **/
    public int update(Usuario usuario) {
        String sql = "UPDATE usuario SET "
                + "nombre_usuario = :nombre_usuario, nombre = :nombre, apellidos = :apellidos, fch_nacimiento = :fch_nacimiento, "
                + "email = :email, telefono=:telefono "
                + "WHERE nombre_usuario = :nombre_usuario;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("nombre_usuario", usuario.getNombreUsuario());
        params.addValue("nombre", usuario.getNombre());
        params.addValue("apellidos", usuario.getApellidos());
        params.addValue("fch_nacimiento", usuario.getFch_nacimiento());
        params.addValue("email", usuario.getEmail());
        params.addValue("telefono", usuario.getTelefono());

        return getNamedJdbcTemplate().update(sql, params);
    }

    @Override
    /** Metodo de tipo int, que realiza una consulta
     * La consulta actualiza la contraseña de un Usuario segun el Id del Usuario
     * **/
    public int updatePass(Usuario usuario) {

        String sql = "UPDATE usuario SET password = :password WHERE id = :id;";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("password", usuario.getPassword());

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
    private class UsuarioRowMapper implements RowMapper {

        public Object mapRow(ResultSet rs, int i) throws SQLException {

            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setFch_nacimiento(rs.getDate("fch_nacimiento"));
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
            usuario.setTelefono(rs.getString("telefono"));

            return usuario;

        }

    }

}
