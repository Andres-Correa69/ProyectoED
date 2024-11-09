package proyecto.colpensionex.repository.csv;

import proyecto.colpensionex.model.Caracterizacion;

import java.io.IOException;

public class CaracterizacionDao extends ADao<Caracterizacion, String>{

    public CaracterizacionDao() throws IOException {
        //declarar ruta
        super("We");
    }
}
