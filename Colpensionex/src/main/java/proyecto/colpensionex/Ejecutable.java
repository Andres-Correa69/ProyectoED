package proyecto.colpensionex;

import proyecto.colpensionex.model.Caracterizacion;
import proyecto.colpensionex.model.Cotizante;
import proyecto.colpensionex.repository.csv.CotizanteDao;
import proyecto.colpensionex.service.Turnos;
import proyecto.colpensionex.service.Validacion;
import proyecto.colpensionex.repository.csv.CaracterizacionDao;


import java.io.IOException;
import java.util.List;
import proyecto.colpensionex.util.EscritorCsvUtil;

import java.io.IOException;
import java.util.List;

public class Ejecutable {
    public static void main(String[] args) throws IOException {
        CotizanteDao cotizanteDao = new CotizanteDao();
        CaracterizacionDao caracterizacionDao = new CaracterizacionDao();

        // Cargar cotizantes y caracterizaciones
        List<Cotizante> cotizantes = cotizanteDao.obtenerTodos();
        List<Caracterizacion> caracterizaciones = caracterizacionDao.obtenerTodos();

        Validacion validaciones = new Validacion();
        validaciones.validarCotizantes(cotizantes, caracterizaciones);
        validaciones.rellenarListas(cotizantes);

        // Cargar listas
        List<Cotizante> listaAceptados = validaciones.getListaAceptados();
        List<Cotizante> listaRechazados = validaciones.getListaRechazados();
        List<Cotizante> listaInhabilitados = validaciones.getListaInhabilitados();
        List<Cotizante> listaEmbargados = validaciones.getListaEmbargados();
        List<Cotizante> listaNegra = validaciones.getListaNegra();

        // Verificación temporal de listas
        System.out.println("Aceptados: " + listaAceptados.size());
        System.out.println("Rechazados: " + listaRechazados.size());
        System.out.println("Inhabilitados: " + listaInhabilitados.size());
        System.out.println("Embargados: " + listaEmbargados.size());
        System.out.println("Lista Negra: " + listaNegra.size());

        // Guardar cada lista en un archivo CSV en la nueva ruta
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/aceptados.csv", listaAceptados);
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/rechazados.csv", listaRechazados);
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/inhabilitados.csv", listaInhabilitados);
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/embargados.csv", listaEmbargados);
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/lista_negra.csv", listaNegra);

        // Crear turnos y cargar lista de aceptados
        Turnos turnos = new Turnos();
        turnos.cargarCotizantes(listaAceptados);

        // Obtener lista de enturnados y escribir en CSV
        List<Cotizante> listaEnturnados = turnos.getListaEnturnados();
        EscritorCsvUtil.escribirCsv("src/main/resources/files/archivosExportados/enturnados.csv", listaEnturnados);
    }
}
