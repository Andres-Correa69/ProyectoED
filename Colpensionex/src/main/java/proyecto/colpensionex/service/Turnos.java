package proyecto.colpensionex.service;

import proyecto.colpensionex.model.Cotizante;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Turnos {
    private PriorityQueue<Cotizante> queue;

    public Turnos() {
        // Configuramos el comparador en el constructor de Turnos
        Comparator<Cotizante> comparator = (c1, c2) -> {
            if ((c1.getEdad() < 35 && c2.getEdad() >= 35)) return -1; // c1 tiene prioridad
            if ((c1.getEdad() >= 35 && c2.getEdad() < 35)) return 1; // c2 tiene prioridad
            return Integer.compare(c1.getEdad(), c2.getEdad()); // si ambos son del mismo grupo, ordena por edad ascendente
        };
        this.queue = new PriorityQueue<>(comparator);
    }

    // Método para agregar una lista de cotizantes a la PriorityQueue
    public void cargarCotizantes(List<Cotizante> cotizantes) {
        queue.addAll(cotizantes);
    }

    // Método para extraer cotizantes en orden de prioridad
    public void atenderCotizantes() {
        System.out.println("Cotizantes en orden de prioridad (menores de 35 primero):");
        while (!queue.isEmpty()) {
            Cotizante cotizante = queue.poll();
            System.out.println(cotizante.getNombre() + " - Edad: " + cotizante.getEdad());
        }
    }
}