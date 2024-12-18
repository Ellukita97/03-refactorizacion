package org.example.a;

import java.time.LocalTime;

public class Reserva {
    private Cliente cliente;
    private int precioTotal;
    private LocalTime horaLlegada;
    private TipoHabitacion tipoHabitacion;
    private int diaInicio;
    private int diaFin;

    public Reserva(Cliente cliente, int precioTotal, LocalTime horaLlegada, TipoHabitacion tipoHabitacion, int diaInicio, int diaFin) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.horaLlegada = horaLlegada;
        this.tipoHabitacion = tipoHabitacion;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
    }

    public void mostrarDetallesReserva() {
        System.out.println("Cliente: \n");
        getCliente().mostrarDatos();
        System.out.println("Precio total: " + getPrecioTotal());
        System.out.println("Hora de llegada: " + getHoraLlegada());
        System.out.println("Habitaciones: \n");
        getTipoHabitacion().mostrarDatos();
        System.out.println("Dia de inicio: " + getDiaInicio());
        System.out.println("Dia de final: " + getDiaFin());
    }

    // Getters and setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(int diaFin) {
        this.diaFin = diaFin;
    }
}
