package com.backend.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/* Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria*/
public class ForoTemasDatos implements Serializable {

	// Campo el cual es el número de versión de la clase
	private static final long serialVersionUID = 1L;

	// Variables

	private Integer id_tema;
	private Integer id_usuario;
	private String nombre_tema;
	private String comentario_tema;
	// Con esta anotación le proporcionamos la hora y fecha actual al campo
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fch_hora_tema = new Date();
	private String nombre_usuario;

	// GETTERS AND SETTERS

	public Integer getId_tema() {
		return id_tema;
	}
	
	public void setId_tema(Integer id_tema) {
		this.id_tema = id_tema;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_tema() {
		return nombre_tema;
	}

	public void setNombre_tema(String nombre_tema) {
		this.nombre_tema = nombre_tema;
	}

	public String getComentario_tema() {
		return comentario_tema;
	}

	public void setComentario_tema(String comentario_tema) {
		this.comentario_tema = comentario_tema;
	}

	public Date getFch_hora_tema() {
		return fch_hora_tema;
	}

	public void setFch_hora_tema(Date fch_hora_tema) {
		this.fch_hora_tema = fch_hora_tema;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
}
