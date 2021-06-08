package com.backend.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Date;

// Con la antoación @Entity indicamos que es una entidad
@Entity
// Se indica como se llama la tabla de esta entidad
@Table(name = "usuario")
/* Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria*/
public class Usuario {

    // Variables

    //Con esta anotación indicamos que es el Identificador de la tabla
    @Id
    // Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Con esta anotación indicamos que no puede ser null
    @NotNull
    private String nombre;
    // Con esta anotación indicamos que no puede ser null
    @NotNull
    // Con esta anotación indicamos que es un valor único
    @Column(unique = true)
    private String nombreUsuario;
    // Con esta anotación indicamos que no puede ser null
    @NotNull
    private String email;
    // Con esta anotación indicamos que no puede ser null
    @NotNull
    private String password;
    // Con esta anotación indicamos que no puede ser null ni estar vacío
    @NotBlank
    private String apellidos;
    private Date fch_nacimiento;
    private String telefono;

    // Contructor de la clase
    public Usuario() {
    }

    // Contructor de la clase con variables
    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password,  @NotNull String apellidos, Date fch_nacimiento, String telefono) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.apellidos= apellidos;
        this.fch_nacimiento= fch_nacimiento;
        this.telefono= telefono;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFch_nacimiento() {
		return fch_nacimiento;
	}

	public void setFch_nacimiento(Date fch_nacimiento) {
		this.fch_nacimiento = fch_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
