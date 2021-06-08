package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

/** Con la antoación @Entity indicamos que es una entidad **/
@Entity
/** Se indica como se llama la tabla de esta entidad **/
@Table(name="alojamientos")
/** Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria **/
public class Alojamientos implements Serializable {

    /** Campo el cual es el número de versión de la clase **/
	private static final long serialVersionUID = 1L;

    /** Variables

     /**Con esta anotación indicamos que es el Identificador de la tabla **/
	@Id
    /** Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlojamiento;
    private int idLocalizacion;
    private String imagen;
    private String nombre;
    private String descripcion;
    private String url;

    // Contructor de la clase **/
    public Alojamientos(){}

    // Contructor con las variables **/
    public Alojamientos(int idAlojamiento, int idLocalizacion, String imagen, String nombre, String descripcion, String url) {
        this.idAlojamiento = idAlojamiento;
        this.idLocalizacion = idLocalizacion;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    // GETTERS AND SETTERS

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
