package org.example.a;

import java.util.ArrayList;

public class Hotel extends Alojamiento {
    private ArrayList<TipoHabitacion> listaHabitaciones;

    public Hotel(String nombre, String ciudad, float calificacion, ArrayList<TipoHabitacion> listaHabitaciones) {
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
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Tipo de habitacion: \n");
        verTiposHabitacion();
    }

    public void verTiposHabitacion() {
        for (TipoHabitacion unHabitacion: getListaHabitaciones()){
            System.out.println("------------------------------------------");
            unHabitacion.mostrarDatos();
            System.out.println("------------------------------------------");
        }
    }

    // Getters and setters

    public ArrayList<TipoHabitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<TipoHabitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
}
