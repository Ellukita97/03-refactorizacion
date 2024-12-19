package org.example.a;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static AlojamientoControladoraImplementacion controladoraApp = new AlojamientoControladoraImplementacion();
    public static Scanner Keyboard = new Scanner(System.in);
    public static LinkedList<Habitacion> habitacionesDisponibles;

    public static void main(String[] args) {
        controladoraApp.cargarDatos();
        limpiarConsola();
        System.out.println("-----------------------------");
        System.out.println("BIENVENIDO A Booking Hoteles");
        seleccionarAlojamiento();
    }

    public static void seleccionarAlojamiento() {
        String nombreCiudad = elegirNombreCiudad();
        var alojamiento = elegirAlojamiento();
        int cantHabitaciones = ingresarNumero("Ingrese la cantidad de habitaciones: ");
        int cantAdultos = ingresarCantidadPersonas("Adultos");
        int cantNinios = ingresarCantidadPersonas("Ninios");
        int inicioHospedaje = ingresarFecha("Ingrese la fecha de inicio del hospedaje");
        int finalHospedaje = ingresarFecha("Ingrese la fecha final del hospedaje");
        procesarAlojamiento(alojamiento, nombreCiudad, cantHabitaciones, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        realizarConfirmacionReserva(inicioHospedaje, finalHospedaje);
    }

    private static int ingresarFecha(String mensaje) {
        System.out.println(mensaje);
        return ingresarFecha();
    }

    private static void procesarAlojamiento(Alojamiento alojamiento, String nombreCiudad, int cantHabitaciones, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        controladoraApp.filtrarPorParametros(nombreCiudad, alojamiento, cantHabitaciones, inicioHospedaje, finalHospedaje, cantAdultos, cantNinios);
        if (alojamiento instanceof Hotel) {
            procesarHotel((Hotel) alojamiento, cantHabitaciones, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        } else if (alojamiento instanceof Finca) {
            procesarFinca((Finca) alojamiento, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        }
    }

    private static void procesarHotel(Hotel unHotel, int cantHabitaciones, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        habitacionesDisponibles = unHotel.habitacionesDisponibles(
                unHotel.getNombre(), inicioHospedaje, finalHospedaje, cantAdultos, cantNinios, cantHabitaciones
        );
        seleccionarHabitacion(habitacionesDisponibles, unHotel);
    }

    private static void procesarFinca(Finca unFinca, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        ReservaController.getReserva().setAlojamiento(unFinca);
        ReservaController.getReserva().setPrecioTotal(
                unFinca.calcularPrecio(unFinca.getPrecioNoche(), cantAdultos + cantNinios, inicioHospedaje, finalHospedaje)
        );
    }

    private static void realizarConfirmacionReserva(int inicioHospedaje, int finalHospedaje) {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        limpiarConsola();
        System.out.println("Realizando confirmacion de la reservacion");
        Keyboard.nextLine();
        String nombre = ingresarTexto("Ingrese su nombre: ");
        String apellido = ingresarTexto("Ingrese su apellido: ");
        String email = ingresarTexto("Ingrese su email: ");
        String nacionalidad = ingresarTexto("Ingrese su nacionalidad: ");
        Date fechaNacimiento = ingresarNacimientoFecha();
        String telefono = ingresarTexto("Ingrese su telefono: ");
        LocalTime horaLlegada = ingresarHoraDeLlegada();
        ReservaController.getReserva().setDiaInicio(inicioHospedaje);
        ReservaController.getReserva().setDiaFin(finalHospedaje);
        boolean reservaCompletada = ReservaController.getReserva().reservarHabitacionCliente(
                nombre, apellido, email, nacionalidad, telefono, fechaNacimiento, horaLlegada
        );
        if (!reservaCompletada) {
            System.out.println("ERROR");
            return;
        }
        System.out.println("\nSe ha realizado la reserva con exito");
        ReservaController.getReserva().mostrarDetallesReserva();
        actulizacionReserva(fechaNacimiento, email);
    }

    public static void actulizacionReserva(Date fechaNacimiento, String emailUsuario) {
        boolean salir = false;
        while (!salir) {
            String cambiar = ingresarTexto("Deceas cambiar tu reserva? (Y/N): ");
            if (!cambiar.equalsIgnoreCase("y")) return;
            if (!confirmarIdentidad(fechaNacimiento, emailUsuario)) continue;
            gestionarCambios();
        }
    }

    private static boolean confirmarIdentidad(Date fechaNacimiento, String emailUsuario) {
        System.out.println("------------------------------------------------");
        System.out.println("Para confirmar su identidad necesitamos algunos datos");
        if (!verificarFechaNacimiento(fechaNacimiento)) return false;
        if (!verificarEmail(emailUsuario)) return false;
        System.out.println("Logramos comprobar su identidad");
        return true;
    }

    private static boolean verificarFechaNacimiento(Date fechaNacimiento) {
        System.out.println("ingrese su fecha de nacimiento: ");
        Date fechaIngresada = ingresarNacimientoFecha();
        if (!fechaIngresada.equals(fechaNacimiento)) {
            mostrarError();
            return false;
        }
        return true;
    }

    private static boolean verificarEmail(String emailUsuario) {
        String emailIngresado = ingresarTexto("ingrese su email: ");
        if (!emailIngresado.equalsIgnoreCase(emailUsuario)) {
            mostrarError();
            return false;
        }
        return true;
    }

    private static void mostrarError() {
        limpiarConsola();
        System.out.println("ERROR con los datos ingresados");
    }

    private static void gestionarCambios() {
        boolean salirBucle = false;
        while (!salirBucle) {
            System.out.println("------------------------------------------------");
            System.out.println("Que desea cambiar: ");
            System.out.println("0. Salir");
            System.out.println("1. Cambiar Habitacion");
            System.out.println("2. Cambiar Alojamiento");
            int num = ingresarNumero("");
            salirBucle = gestionarOpciones(num);
        }
    }

    private static boolean gestionarOpciones(int num) {
        switch (num) {
            case 0 -> {
                return true;
            }
            case 1 -> actualizarHabitacion(habitacionesDisponibles);
            case 2 -> seleccionarAlojamiento();
        }
        return false;
    }

    public static void actualizarHabitacion(LinkedList<Habitacion> habitacionesDisponibles) {

        Alojamiento alojamientoReservado = ReservaController.getReserva().getAlojamiento();

        if (alojamientoReservado instanceof Hotel) {
            for (int i = 0; i < habitacionesDisponibles.size(); i++) {
                System.out.println("Id: " + i);
                habitacionesDisponibles.get(i).mostrarDatos();
            }
            selecionarHabitacionAActualizar(alojamientoReservado);
        } else {
            seleccionarAlojamiento();
        }
    }

    public static void selecionarHabitacionAActualizar(Alojamiento alojamientoReservado) {
        while (true) {
            try {
                int idHabitacion = ingresarNumero("Ingrese la id de la habitacion a reservar: ");
                seleccionarHabitacion(habitacionesDisponibles, (Hotel) alojamientoReservado);
                ReservaController.getReserva().setAlojamiento(habitacionesDisponibles.get(idHabitacion), (Hotel) alojamientoReservado);
                return;
            } catch (Exception e) {
                System.out.println("Habitacion no encontrada");
            }
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

    public static void seleccionarHabitacion(LinkedList<Habitacion> habitacionesDisponibles, Hotel hotelAResevar) {
        while (true) {
            System.out.println("-----------------------------");
            try {
                int idHabitacion = ingresarNumero("Ingrese la id de la habitacion a reservar: ");
                ReservaController.getReserva().setAlojamiento(habitacionesDisponibles.get(idHabitacion), hotelAResevar);
                ReservaController.getReserva().setPrecioTotal(habitacionesDisponibles.get(idHabitacion).getPrecio());
                return;
            } catch (Exception _) {
                System.out.println("Habitacion no encontrada");
            }
        }
    }

    public static Date ingresarNacimientoFecha() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            String inputFecha = ingresarTexto("Ingresa una fecha (dd/MM/yyyy): ");
            try {
                return formatoFecha.parse(inputFecha);
            } catch (Exception e) {
                System.out.println("Error: la fecha no tiene el formato correcto.");
            }
        }
    }

    public static LocalTime ingresarHoraDeLlegada() {
        while (true) {
            String input = ingresarTexto("Ingrese una hora en formato HH:mm (ejemplo 14:30):");
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                return LocalTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Hora inválida. Asegúrese de ingresar el formato correcto.");
            }
        }
    }

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
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}