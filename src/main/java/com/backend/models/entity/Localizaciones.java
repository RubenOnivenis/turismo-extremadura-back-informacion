package com.backend.models.entity;

import javax.persistence.*;
import java.io.Serializable;

/** Con la antoación @Entity indicamos que es una entidad **/
@Entity
/** Se indica como se llama la tabla de esta entidad **/
 @Table(name="localizaciones")
/** Implementamos Serializable para indicar que es una clase ubicada en un paquete Java. io. Serializable
 De esta manera convertimos un obj en una secuencia de bytes para almacenarlos o transmitirlos a la memoria **/
public class Localizaciones implements Serializable {

    /** Campo el cual es el número de versión de la clase **/
	private static final long serialVersionUID = 1L;

    // Variables

    /** Con esta anotación indicamos que es el Identificador de la tabla **/
    @Id
    /** Con esta anotación se configura la forma del incremento del campo, como el AUTO_INCREMENT de MYSQL**/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocalizacion;
    private String nombre;
    private String provincia;
    private String comarca;
    private String imagen;
    private String url;

    /** Contructor de la clase **/
    public Localizaciones(){}

    /** Contructor con las variables**/
    public Localizaciones(int idLocalizacion, String nombre, String provincia, String comarca, String imagen, String url) {
        this.idLocalizacion = idLocalizacion;
        this.nombre = nombre;
        this.provincia = provincia;
        this.comarca = comarca;
        this.imagen = imagen;
        this.url = url;
    }

    // GETTERS AND SETTERS

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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
