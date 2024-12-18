package org.example.a;

import java.util.LinkedList;

public class DiaSol {
    private LinkedList<String> actividades;
    private boolean incluyeAlmuerzo;

    public DiaSol(LinkedList<String> actividades, boolean incluyeAlmuerzo) {
        this.actividades = actividades;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }


    public void mostrarDatos() {
        System.out.println("Incluye almuerzo: " + isIncluyeAlmuerzo());
        System.out.println("Actividades: ");
        for (String actividad : getActividades()) {
            System.out.println("1 - " + actividad);
        }
    }

    // Getters and setters

    public LinkedList<String> getActividades() {
        return actividades;
    }

    public void setActividades(LinkedList<String> actividades) {
        this.actividades = actividades;
    }

    public boolean isIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(boolean incluyeAlmuerzo) {
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }
}
