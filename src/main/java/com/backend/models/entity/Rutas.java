package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rutas")
public class Rutas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRuta;
    private int idLocalizacion;
    private String nombre;
    private String imagen;
    private String descripcion;

    public Rutas(){}

    public Rutas(int idRuta, int idLocalizacion, String nombre, String imagen, String descripcion) {
        this.idRuta = idRuta;
        this.idLocalizacion = idLocalizacion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
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
}
