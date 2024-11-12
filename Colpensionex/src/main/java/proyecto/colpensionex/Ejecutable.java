package proyecto.colpensionex;

import proyecto.colpensionex.model.Caracterizacion;
import proyecto.colpensionex.model.Cotizante;
import proyecto.colpensionex.repository.csv.CotizanteDao;
import proyecto.colpensionex.service.Turnos;
import proyecto.colpensionex.service.Validacion;
import proyecto.colpensionex.repository.csv.CaracterizacionDao;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Ejecutable {
    public static void main(String [] args) throws IOException {
        CotizanteDao cotizanteDao = new CotizanteDao();
        cotizanteDao.limpiarCache();
        CaracterizacionDao caracterizacionDao = new CaracterizacionDao();
        caracterizacionDao.limpiarCache();

        List<Cotizante> cotizantes = cotizanteDao.obtenerTodos();
        List<Caracterizacion> caracterizaciones = caracterizacionDao.obtenerTodos();
        Validacion validaciones = new Validacion();
        validaciones.validarCotizantes(cotizantes, caracterizaciones);

//        for(Cotizante cotizante : cotizantes){
//            System.out.println(cotizante.toString());
//        }


        List<Cotizante> cotizantesAceptados = validaciones.getListaAceptados();

        validaciones.rellenarListas(cotizantes);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Selecciona la lista que deseas ver:");
            System.out.println("1. Lista Aceptados");
            System.out.println("2. Lista Rechazados");
            System.out.println("3. Lista Inhabilitados");
            System.out.println("4. Lista Embargados");
            System.out.println("5. Lista Negra");
            System.out.println("6. Orden Turno");
            System.out.println("7. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarLista("Lista Aceptados:", validaciones.getListaAceptados());
                    break;
                case 2:
                    mostrarLista("Lista Rechazados:", validaciones.getListaRechazados());
                    break;
                case 3:
                    mostrarLista("Lista Inhabilitados:", validaciones.getListaInhabilitados());
                    break;
                case 4:
                    mostrarLista("Lista Embargados:", validaciones.getListaEmbargados());
                    break;
                case 5:
                    mostrarLista("Lista Negra:", validaciones.getListaNegra());
                    break;
                case 6:
                    Turnos turnos = new Turnos();
                    turnos.cargarCotizantes(validaciones.getListaAceptados());
                    turnos.atenderCotizantes(); // Muestra los cotizantes en orden de prioridad
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();

    }

    public static void mostrarLista(String titulo, List<Cotizante> lista) {
        System.out.println(titulo);
        for (Cotizante cotizante : lista) {
            System.out.println(cotizante.toString());
        }
    }

}

