package org.example.a;

import java.time.LocalDate;
import java.util.LinkedList;

public class ControladoraImplementacion implements Controladora {
    private LinkedList<Hotel> listaHotel = new LinkedList<>();
    private LinkedList<Finca> listaFinca = new LinkedList<>();
    private LinkedList<Apartamento> listaApartamento = new LinkedList<>();

    private LinkedList<Cliente> cliente;
    private LinkedList<Reserva> reserva;

    public ControladoraImplementacion() {
    }

    @Override
    public void cargarDatos() {
        //Por Implementar
    }

    @Override
    public void filtrarPorParametros() {
        //Por Implementar
    }

    @Override
    public void confirmarHabitaciones() {
        //Por Implementar
    }

    @Override
    public void reservarAlojamientoOHabitacion() {
        //Por Implementar
    }

    @Override
    public void actualizarReserva() {
        //Por Implementar
    }

    @Override
    public void actualizarAlojamiento() {
        //Por Implementar
    }

}
