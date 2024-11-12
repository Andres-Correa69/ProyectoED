package proyecto.colpensionex.util;


import proyecto.colpensionex.model.Cotizante;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
public class EscritorCsvUtil {

    /**
     * Método para escribir una lista de cotizantes en un archivo CSV.
     *
     * @param rutaArchivo Ruta del archivo CSV a crear o sobrescribir.
     * @param cotizantes  Lista de cotizantes que se escribirá en el archivo.
     */
    public static void escribirCsv(String rutaArchivo, List<Cotizante> cotizantes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir encabezados
            writer.write("Cedula,Nombre,Edad,Correo,Telefono,DeclaraRenta,HaEstadoListaNegra,EsPrePensionado,PerteneceInsPublica,InstitucionPublica,TieneCondecoracion,TieneHijosInpec,TieneFamPolicia,EsElMayorEdad,ObservacionDisciplinaria,Semanas,CiudadNacimiento,CiudadResidencia,AlcanzoEdadRPM,Fondo,Estado");
            writer.newLine();

            // Escribir datos de cada cotizante
            for (Cotizante cotizante : cotizantes) {
                writer.write(String.format("%s,%s,%d,%s,%s,%b,%b,%b,%b,%s,%b,%b,%b,%b,%b,%d,%s,%s,%b,%s,%s",
                        cotizante.getCedula(),
                        cotizante.getNombre(),
                        cotizante.getEdad(),
                        cotizante.getCorreo(),
                        cotizante.getTelefono(),
                        cotizante.getDeclaraRenta(),
                        cotizante.getHaEstadoListaNegra(),
                        cotizante.getEsPrePensionado(),
                        cotizante.getPerteneceInsPublica(),
                        cotizante.getInstitucionPublica(),
                        cotizante.getTieneCondecoracion(),
                        cotizante.getTieneHijosInpec(),
                        cotizante.getTieneFamPolicia(),
                        cotizante.getEsElMayorEdad(),
                        cotizante.getObservacionDisciplinaria(),
                        cotizante.getSemanas(),
                        cotizante.getCiudadNacimiento(),
                        cotizante.getCiudadResidencia(),
                        cotizante.getAlcanzoEdadRPM(),
                        cotizante.getFondo(),
                        cotizante.getEstado()
                ));
                writer.newLine(); // Nueva línea para cada cotizante
            }

            System.out.println("Archivo CSV escrito exitosamente: " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
