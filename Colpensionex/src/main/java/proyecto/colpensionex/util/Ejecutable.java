package proyecto.colpensionex.util;

import proyecto.colpensionex.model.Cotizante;
import proyecto.colpensionex.repository.csv.CotizanteDao;
import proyecto.colpensionex.service.Validacion;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Ejecutable {
    public static void main(String[] args) throws IOException {
        CotizanteDao cotizanteDao = new CotizanteDao();
        List<Cotizante> cotizantes = cotizanteDao.obtenerTodos();
        Validacion validaciones = new Validacion();
        validaciones.validarCotizantes(cotizantes);

        // Imprimir la lista de cotizantes después de la validación
        System.out.println("\nLista completa de cotizantes:"+"\n");
        cotizantes.forEach(cotizante -> System.out.println(cotizante));

        // Obtener la lista negra y mostrarla por consola
        List<Cotizante> listaNegra = validaciones.getListaNegra();
        System.out.println("\nLista negra de cotizantes:"+"\n");
        listaNegra.forEach(cotizante -> System.out.println(cotizante));

        // Escribir la lista negra en un archivo CSV
        escribirListaNegraEnCSV(listaNegra, "lista_negra.csv");
    }

    private static void escribirListaNegraEnCSV(List<Cotizante> listaNegra, String nombreArchivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nombreArchivo);

            // Escribir la cabecera
            fileWriter.write("id,nombre,estado,haEstadoListaNegra\n");

            // Escribir cada cotizante de la lista negra
            for (Cotizante cotizante : listaNegra) {
                fileWriter.write(cotizante.getCedula() + ";" + cotizante.getNombre() + ";" +
                        cotizante.getEstado() + ";" + cotizante.getHaEstadoListaNegra() + "\n");
            }

            System.out.println("\nArchivo lista_negra.csv creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
