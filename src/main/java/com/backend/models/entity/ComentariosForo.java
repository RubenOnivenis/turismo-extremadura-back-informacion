package com.backend.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Con la antoación @Entity indicamos que es una entidad
@Entity
// Se indica como se llama la tabla de esta entidad
@Table(name="comentarios_foro")
/* Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria*/
public class ComentariosForo implements Serializable {

    // Campo el cual es el número de versión de la clase
	private static final long serialVersionUID = 1L;

	// Variables

    //Con esta anotación indicamos que es el Identificador de la tabla
    @Id
    // Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentarioForo;
    private String comentario;
    private int idUsuario;
    private int idTema;
    // Con esta anotación le proporcionamos la hora y fecha actual al campo
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fchHoraComentario = new Date();

    // Contructor de la clase
    public ComentariosForo() { }

    // Contructor con las variables
    public ComentariosForo(int idComentarioForo, String comentario, int idUsuario, int idTema, Date fchHoraComentario) {
        this.idComentarioForo = idComentarioForo;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.idTema = idTema;
        this.fchHoraComentario = fchHoraComentario;
    }

    // GETTERS AND SETTERS

    public int getIdComentarioForo() {
        return idComentarioForo;
    }

    public void setIdComentarioForo(int idComentarioForo) {
        this.idComentarioForo = idComentarioForo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public Date getFchHoraComentario() {
        return fchHoraComentario;
    }

    public void setFchHoraComentario(Date fchHoraComentario) {
        this.fchHoraComentario = fchHoraComentario;
    }
}
