package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rutas")
public class Rutas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuta;
    private int idLocalizacion;
    private String nombre;
    private String imagen;
    private String descripcion;
    private String url;

    public Rutas() {
    }

    public Rutas(int idRuta, int idLocalizacion, String nombre, String imagen, String descripcion, String url) {
        this.idRuta = idRuta;
        this.idLocalizacion = idLocalizacion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.url = url;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
