package proyecto.colpensionex.util;

import proyecto.colpensionex.model.Cotizante;
import proyecto.colpensionex.repository.csv.CotizanteDao;
import proyecto.colpensionex.service.Validacion;

import java.io.IOException;
import java.util.List;

public class Ejecuitable {
    public static void main(String [] args) throws IOException {
        CotizanteDao cotizanteDao = new CotizanteDao();
        List<Cotizante> cotizantes = cotizanteDao.obtenerTodos();
        Validacion validaciones = new Validacion();
        validaciones.validarCotizantes(cotizantes);

        // Imprimir la lista de cotizantes después de la validación
        System.out.println("\nLista completa de cotizantes:"+"\n");
        cotizantes.forEach(cotizante -> System.out.println(cotizante));

    }
}
