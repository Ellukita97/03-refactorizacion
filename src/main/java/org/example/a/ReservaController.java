package org.example.a;

public class ReservaController {
    private static Cliente cliente;
    private static Reserva reserva = new Reserva();

    public ReservaController() {
    }

    public static void verReserva(){

    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        ReservaController.cliente = cliente;
    }

    public static Reserva getReserva() {
        return reserva;
    }

    public static void setReserva(Reserva reserva) {
        ReservaController.reserva = reserva;
    }
}
