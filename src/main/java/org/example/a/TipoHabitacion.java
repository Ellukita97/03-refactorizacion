package org.example.a;

public class TipoHabitacion {
    private String titulo;
    private String descripcion;
    private Integer cantidad;
    private Integer precio;

    public TipoHabitacion(String titulo, String descripcion, int cantidad, int precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Descripcion : " + getDescripcion());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Precio: $ " + getPrecio());
    }

    // Getters and setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
