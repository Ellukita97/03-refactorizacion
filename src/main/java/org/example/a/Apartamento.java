package org.example.a;

import java.util.LinkedList;

public class Apartamento extends Alojamiento {
    private Integer precioNoche;
    private Integer cantidadHabitaciones;
    private String descripcion;

    public Apartamento(String nombre, String ciudad, float calificacion, int precioNoche, int cantidadHabitaciones, String descripcion) {
        super(nombre, ciudad, calificacion);
        this.precioNoche = precioNoche;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.descripcion = descripcion;
    }


    @Override
    public float calcularPrecioMasBajo(int diaInicio, int diaFinal) {
        return 0;
    }

    @Override
    public float calcularPrecio(float precio, int cantidadPersonas, int diaInicio, int diaFinal) {
        System.out.println(diaFinal + diaInicio);
        // Implementation for calculating hotel price
        return 2;
    }

    @Override
    public void verAlojamiento() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificacion: " + getCalificacion());
        System.out.println("Precio por noche: " + getPrecioNoche());
        System.out.println("Cantidad de habitaciones: " + getCantidadHabitaciones());
        System.out.println("Descripcion: " + getDescripcion());
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