package proyecto.colpensionex.service;

import proyecto.colpensionex.model.Cotizante;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;


public class Turnos {
    private PriorityQueue<Cotizante> queue;

    public Turnos() {
        // Configuramos el comparador en el constructor de Turnos
        Comparator<Cotizante> comparator = (c1, c2) -> {
            // Prioridad 1: Edad menor de 35
            if ((c1.getEdad() < 35 && c2.getEdad() >= 35)) return -1; // c1 tiene prioridad
            if ((c1.getEdad() >= 35 && c2.getEdad() < 35)) return 1; // c2 tiene prioridad

            // Prioridad 2: No declaran renta
            if (!c1.getDeclaraRenta() && c2.getDeclaraRenta()) return -1; // c1 tiene prioridad
            if (c1.getDeclaraRenta() && !c2.getDeclaraRenta()) return 1; // c2 tiene prioridad

            // Si ambos cumplen los mismos criterios, ordenamos por edad ascendente
            return Integer.compare(c1.getEdad(), c2.getEdad());
        };
        this.queue = new PriorityQueue<>(comparator);
    }

    // Método para agregar una lista de cotizantes a la PriorityQueue
    public void cargarCotizantes(List<Cotizante> cotizantes) {
        queue.addAll(cotizantes);
    }

    // Método para extraer cotizantes en orden de prioridad en una lista
    public List<Cotizante> getListaEnturnados() {
        List<Cotizante> enturnados = new ArrayList<>();
        while (!queue.isEmpty()) {
            enturnados.add(queue.poll());
        }
        return enturnados;
    }

    // Método opcional para imprimir los cotizantes en orden de prioridad
    public void atenderCotizantes() {
        System.out.println("Cotizantes en orden de prioridad (menores de 35 y no declaran renta primero):");
        for (Cotizante cotizante : getListaEnturnados()) {
            System.out.println(cotizante.getNombre() + " - Edad: " + cotizante.getEdad() + ", Declara Renta: " + cotizante.getDeclaraRenta());
        }
    }
}
