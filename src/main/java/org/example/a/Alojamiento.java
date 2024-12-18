package org.example.a;

public abstract class Alojamiento {
    private String nombre;
    private String ciudad;
    private float calificacion;

    public Alojamiento(String nombre, String ciudad, float calificacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calificacion = calificacion;
    }

    public abstract float calcularPrecio();

    public abstract void verAlojamiento();

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
