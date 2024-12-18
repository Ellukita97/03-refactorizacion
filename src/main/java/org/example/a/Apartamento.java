package org.example.a;

public class Apartamento extends Alojamiento {
    private int precioNoche;
    private int cantidadHabitaciones;
    private String descripcion;

    public Apartamento(String nombre, String ciudad, float calificacion, int precioNoche, int cantidadHabitaciones, String descripcion) {
        super(nombre, ciudad, calificacion);
        this.precioNoche = precioNoche;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.descripcion = descripcion;
    }

    @Override
    public float calcularPrecio() {
        // Por Realizar
        return 0;
    }

    @Override
    public void verAlojamiento() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Precio por noche: " + getPrecioNoche());
        System.out.println("Cantidad de habitaciones: " + getCantidadHabitaciones());
        System.out.println("Descripción: " + getDescripcion());
    }

    // Getters and setters

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }
}