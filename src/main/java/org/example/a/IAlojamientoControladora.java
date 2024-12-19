package org.example.a;

public interface IAlojamientoControladora {
    void cargarDatos();

    void filtrarPorParametros(String ciudad, Alojamiento alojamientoElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios);

    void confirmarHabitaciones();
    void reservarAlojamientoOHabitacion();
    void actualizarReserva();
    void actualizarAlojamiento();
}
