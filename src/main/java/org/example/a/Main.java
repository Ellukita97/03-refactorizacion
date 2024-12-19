package org.example.a;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static AlojamientoControladoraImplementacion controladoraApp = new AlojamientoControladoraImplementacion();
    public static Scanner Keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        controladoraApp.cargarDatos();
        limpiarConsola();

        System.out.println("-----------------------------");
        System.out.println("BIENVENIDO A Booking Hoteles");
        System.out.println("Elija el tipo de alojamiento que desea");
        String nombreCiudad = elegirNombreCiudad();
        var alojamiento = elegirAlojamiento();
        int cantHabitaciones = ingresarNumero("Ingrese la cantidad de habitaciones: ");
        int cantAdultos = ingresarCantidadPersonas("Adultos");
        int cantNinios = ingresarCantidadPersonas("Ninios");
        System.out.println("Ingrese la fecha de inicio del hospedaje");
        int inicioHospedaje = ingresarFecha();
        System.out.println("Ingrese la fecha final del hospedaje");
        int finalHospedaje = ingresarFecha();

        controladoraApp.filtrarPorParametros(nombreCiudad, alojamiento, cantHabitaciones, inicioHospedaje, finalHospedaje, cantAdultos, cantNinios);
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        if (alojamiento instanceof Hotel) {
            Hotel unHotel = (Hotel) alojamiento;
            unHotel.habitacionesDisponibles(unHotel.getNombre(), inicioHospedaje, finalHospedaje, cantAdultos, cantNinios, cantHabitaciones);
        }

    }

    public static String elegirNombreCiudad() {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Realize su reserva de habitaciones");
            System.out.println("Elija la ciudad de el hotel al que desea viajar");
            String ciudad = ingresarTexto("Escriba el nombre de la ciudad ");
            if (controladoraApp.buscarCiudadNombre(ciudad)) return ciudad;
        }
    }

    public static Alojamiento elegirAlojamiento() {
        String[] tipoAlojamiento = {"Hotel", "Finca", "Apartamento"};
        while (true) {
            for (String tipo : tipoAlojamiento) {
                controladoraApp.mostrarTodosAlojamientos(tipo);
                int num = ingresarNumero("Eliga una opción (id para elegir " + tipo + ", o -1 para continuar): ");
                Alojamiento alojamientoElegido = controladoraApp.econtrarAlojamientos(tipo, num);
                if (alojamientoElegido != null) return alojamientoElegido;
            }
        }
    }

    public static int ingresarCantidadPersonas(String tipoPersona) {
        System.out.println("-----------------------------");
        int cantPersonas = ingresarNumeroPositivo("Ingrese la cantidad de " + tipoPersona + " a ingresar: ");
        System.out.println("-----------------------------");
        return cantPersonas;
    }

    private static int ingresarNumeroPositivo(String mensaje) {
        while (true) {
            int numero = ingresarNumero(mensaje);
            if (numero > 0) return numero;
            System.out.println("No es un numero válido");
        }
    }

    public static int ingresarFecha() {
        while (true) {
            int dia = ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }
            return dia;
        }
    }

    /*public static void seleccionarHabitacion(LinkedList<Habitacion> habitaciones, ReservacionCliente reservacionCliente) {
        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            int idHabitacion = Sistema.ingresarNumero("Ingrese la id de la habitacion a reservar: ");


            for (int i = 0; i < habitaciones.size(); i++) {
                if (habitaciones.get(i).getIdHabitacion() == idHabitacion) {

                    reservacionCliente.setHabitacionCompradaDatos(habitaciones.get(i));
                    System.out.println("Habitacion seleccionada con exito");
                    return;
                }
            }

            //limpiarConsola();
            System.out.println("Habitacion no encontrada");
        }

    }*/


    public static String ingresarTexto(String msg) {
        System.out.print(msg);
        return Keyboard.nextLine();
    }

    public static int ingresarNumero(String msg) {
        int numero = 0;
        System.out.print(msg);
        while (true) {
            if (Keyboard.hasNextInt()) {
                numero = Keyboard.nextInt();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                Keyboard.next();
            }
        }
        return numero;
    }

    public static void limpiarConsola() {
        // Imprime 50 líneas en blanco para simular la limpieza
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}