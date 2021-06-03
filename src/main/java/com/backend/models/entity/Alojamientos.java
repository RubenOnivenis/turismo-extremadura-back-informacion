package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="alojamientos")
public class Alojamientos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlojamiento;

    private int idLocalizacion;
    private String imagen;
    private String nombre;
    private String descripcion;
    private String url;

    public Alojamientos(){}

    public Alojamientos(int idAlojamiento, int idLocalizacion, String imagen, String nombre, String descripcion, String url) {
        this.idAlojamiento = idAlojamiento;
        this.idLocalizacion = idLocalizacion;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
