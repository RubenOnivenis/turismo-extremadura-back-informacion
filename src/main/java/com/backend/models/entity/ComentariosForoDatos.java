package com.backend.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria **/
public class ComentariosForoDatos implements Serializable {

    /** Campo el cual es el número de versión de la clase **/
	private static final long serialVersionUID = 1L;

    // Variables

	private int idComentarioForo;
    private String comentario;
    private int idUsuario;
    private int idTema;
    /**Con esta anotación le proporcionamos la hora y fecha actual al campo **/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fchHoraComentario = new Date();
    private String nombreUsuario;
    private String nombreTema;
    private String descripcionTema;

    /** Contructor de la clase **/
    public ComentariosForoDatos() {
    }

    /** Contructor de la clase con las variables**/
    public ComentariosForoDatos(int idComentarioForo, String comentario, int idUsuario, int idTema, Date fchHoraComentario, String nombreUsuario, String nombreTema, String descripcionTema) {
        this.idComentarioForo = idComentarioForo;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.idTema = idTema;
        this.fchHoraComentario = fchHoraComentario;
        this.nombreUsuario = nombreUsuario;
        this.nombreTema = nombreTema;
        this.descripcionTema = descripcionTema;
    }

    /** GETTERS AND SETTERS **/

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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getDescripcionTema() {
        return descripcionTema;
    }

    public void setDescripcionTema(String descripcionTema) {
        this.descripcionTema = descripcionTema;
    }
}
