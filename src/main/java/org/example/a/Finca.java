package org.example.a;

public class Finca extends Alojamiento {
    private DiaSol diaSol;
    private int precioNoche;
    private int cantidadHabitaciones;
    private String descripcion;

    public Finca(String nombre, String ciudad, float calificacion, DiaSol diaSol, int precioNoche, int cantidadHabitaciones, String descripcion) {
        super(nombre, ciudad, calificacion);
        this.diaSol = diaSol;
        this.precioNoche = precioNoche;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.descripcion = descripcion;
    }

    @Override
    public float calcularPrecio() {
        // Implementation for calculating finca price
        return 0;
    }

    @Override
    public void verAlojamiento() {
        if(getDiaSol() == null) {
            System.out.println("No hay dia de sol");
            return;
        }

        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Precio por noche: " + getPrecioNoche());
        System.out.println("Cantidad de habitaciones: " + getCantidadHabitaciones());
        System.out.println("Descripción: " + getDescripcion());
        getDiaSol().mostrarDatos();
    }

    // Getters and setters

    public DiaSol getDiaSol() {
        return diaSol;
    }

    public void setDiaSol(DiaSol diaSol) {
        this.diaSol = diaSol;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
