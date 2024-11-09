package proyecto.colpensionex.util;

import proyecto.colpensionex.model.Cotizante;
import proyecto.colpensionex.repository.csv.CotizanteDao;

import java.io.IOException;
import java.util.List;

public class Ejecuitable {
    public static void main(String [] args) throws IOException {
        CotizanteDao cotizanteDao = new CotizanteDao();
        List<Cotizante> cotizantes = cotizanteDao.obtenerTodos();

        for(Cotizante cotizante : cotizantes){
            System.out.println(cotizante.toString());
        }
    }
}
