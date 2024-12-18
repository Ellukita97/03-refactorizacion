package org.example.a;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hotel extends Alojamiento {
    private LinkedList<TipoHabitacion> listaHabitaciones;

    public Hotel(String nombre, String ciudad, float calificacion, LinkedList<TipoHabitacion> listaHabitaciones) {
        super(nombre, ciudad, calificacion);
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public float calcularPrecio() {
        // Implementation for calculating hotel price
        return 0;
    }

    @Override
    public void verAlojamiento() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificacion: " + getCalificacion());
        System.out.println("Tipo de habitacion:");
        verTiposHabitacion();
    }

    public void verTiposHabitacion() {
        for (TipoHabitacion unHabitacion: getListaHabitaciones()){
            System.out.println("------------------------------------------");
            unHabitacion.mostrarDatos();
        }
        System.out.println("------------------------------------------");
    }

    // Getters and setters

    public LinkedList<TipoHabitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(LinkedList<TipoHabitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
}
