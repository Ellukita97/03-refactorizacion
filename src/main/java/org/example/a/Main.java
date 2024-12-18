package org.example.a;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Apartamento apartamento1 = new Apartamento("City View Apartment", "New York", 4.2f, 120, 2, "Spacious apartment with city views");


        LinkedList<String> listaActividades = new LinkedList<>();
        listaActividades.add("Hiking");
        listaActividades.add("swimming");
        listaActividades.add("campfire");
        DiaSol diaSol = new DiaSol(listaActividades, true);
        Finca finca1 = new Finca("Mountain View Finca", "Colorado", 4.8f, diaSol, 150, 3, "Beautiful mountain view and peaceful atmosphere");

        LinkedList<TipoHabitacion> habitaciones = new LinkedList<>();
        habitaciones.add(new TipoHabitacion("Standard", "Single room with basic amenities", 10, 50));
        habitaciones.add(new TipoHabitacion("Deluxe", "Double room with additional amenities", 5, 100));
        Hotel hotel1 = new Hotel("Hotel XYZ", "New York", 4.5f, habitaciones);


        Cliente cliente = new Cliente("John", "Doe", "USA", "123-456-7890", "johndoe@example.com", LocalDate.of(1990, 1, 1));
        TipoHabitacion habitacion = new TipoHabitacion("Standard", "Single room with basic amenities", 10, 50);

        Reserva reserva1 = new Reserva(cliente, 200, LocalTime.of(12, 0), habitacion, 1, 5);





        apartamento1.verAlojamiento();
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        finca1.verAlojamiento();
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        hotel1.verAlojamiento();
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        cliente.mostrarDatos();
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        habitacion.mostrarDatos();
        System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        reserva1.mostrarDetallesReserva();
    }
}