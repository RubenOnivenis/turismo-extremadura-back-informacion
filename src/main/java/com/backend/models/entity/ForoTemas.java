package com.backend.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Con la antoación @Entity indicamos que es una entidad
@Entity
// Se indica como se llama la tabla de esta entidad
@Table(name="foro_temas")
/* Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria*/
public class ForoTemas implements Serializable {

    // Campo el cual es el número de versión de la clase
	private static final long serialVersionUID = 1L;

    // Variables

    //Con esta anotación indicamos que es el Identificador de la tabla
    @Id
    // Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTema;
    private String nombreTema;
    private String comentarioTema;
    private int idUsuario;
    // Con esta anotación le proporcionamos la hora y fecha actual al campo
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fchHoraTema = new Date();

    // Contructor de la clase
    public ForoTemas() { }

    // Contructor con las variables
    public ForoTemas(int idTema, String nombreTema, String comentarioTema, int idUsuario, Date fchHoraTema) {
        this.idTema = idTema;
        this.nombreTema = nombreTema;
        this.comentarioTema = comentarioTema;
        this.idUsuario = idUsuario;
        this.fchHoraTema = fchHoraTema;
    }

    // GETTERS AND SETTERS

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getComentarioTema() {
        return comentarioTema;
    }

    public void setComentarioTema(String comentarioTema) {
        this.comentarioTema = comentarioTema;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFchHoraTema() {
        return fchHoraTema;
    }

    public void setFchHoraTema(Date fchHoraTema) {
        this.fchHoraTema = fchHoraTema;
    }
}
