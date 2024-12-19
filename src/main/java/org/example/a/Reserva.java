package org.example.a;

import java.time.LocalTime;
import java.util.LinkedList;

public class Reserva {
    private Cliente cliente;
    private Integer precioTotal;
    private LocalTime horaLlegada;
    private Alojamiento alojamiento;
    private Integer diaInicio;
    private Integer diaFin;

    public Reserva() {
    }

    public Reserva(Cliente cliente, int precioTotal, LocalTime horaLlegada, Alojamiento alojamiento, int diaInicio, int diaFin) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.horaLlegada = horaLlegada;
        this.alojamiento = alojamiento;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
    }

    public void mostrarDetallesReserva() {
        System.out.println("------------------------------------------");
        System.out.println("Cliente: \n");
        getCliente().mostrarDatos();
        System.out.println("------------------------------------------");
        System.out.println("Hora de llegada: " + getHoraLlegada());
        System.out.println("Dia de inicio: " + getDiaInicio());
        System.out.println("Dia de final: " + getDiaFin());
        System.out.println("Precio total: $ " + getPrecioTotal());
        System.out.println("------------------------------------------");
        System.out.println(" \nHabitaciones: \n");
        alojamiento.verAlojamiento();
        System.out.println("------------------------------------------");
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

    public Alojamiento getTipoHabitacion() {
        return alojamiento;
    }

    public void setTipoHabitacion(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion, Hotel unHotel) {
        LinkedList<TipoHabitacion> habitacionComprada = new LinkedList<>();
        Hotel hotelAlquilado = unHotel;
        hotelAlquilado.setListaHabitaciones(habitacionComprada);
        this.alojamiento = unHotel;
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
