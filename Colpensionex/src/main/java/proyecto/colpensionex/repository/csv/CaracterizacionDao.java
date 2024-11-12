package proyecto.colpensionex.repository.csv;

import proyecto.colpensionex.model.Caracterizacion;

import java.io.IOException;

import proyecto.colpensionex.model.Caracterizacion;

import proyecto.colpensionex.model.Caracterizacion;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CaracterizacionDao extends ADao<Caracterizacion, String> {

    public CaracterizacionDao() throws IOException {
        // Obtener todas las rutas de archivos CSV en el directorio especificado
        super(obtenerRutasArchivos("src/main/resources/files/caracterizacion/"));
    }

    // Método estático para obtener las rutas de todos los archivos CSV en el directorio
    private static List<String> obtenerRutasArchivos(String directorio) {
        File carpeta = new File(directorio);
        if (carpeta.isDirectory()) {
            return Arrays.stream(carpeta.listFiles((dir, name) -> name.endsWith(".csv")))
                    .map(File::getAbsolutePath)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    protected String obtenerIdEntidad(Caracterizacion entidad) {
        // Asumimos que Caracterizacion tiene un método getCedula() para obtener el ID
        return entidad.getCedula();
    }
}

