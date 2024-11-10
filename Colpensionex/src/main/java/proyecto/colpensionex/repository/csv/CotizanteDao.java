package proyecto.colpensionex.repository.csv;

import proyecto.colpensionex.model.Cotizante;

import java.io.IOException;

public class CotizanteDao extends ADao<Cotizante, String> {
    public CotizanteDao() throws IOException {
        //definir la ruta
            super("C:\\Users\\juanx\\Downloads\\ProyectoED\\Colpensionex\\src\\main\\resources\\files\\cotizantes.csv");
    }
}
