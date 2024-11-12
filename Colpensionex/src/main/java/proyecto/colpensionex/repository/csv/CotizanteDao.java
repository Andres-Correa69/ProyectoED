package proyecto.colpensionex.repository.csv;

import proyecto.colpensionex.model.Cotizante;

import java.io.IOException;

import proyecto.colpensionex.model.Cotizante;

import proyecto.colpensionex.model.Cotizante;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CotizanteDao extends ADao<Cotizante, String> {

    public CotizanteDao() throws IOException {
        // Obtener todas las rutas de archivos CSV en el directorio
        super(obtenerRutasArchivos("C:\\Users\\corre\\OneDrive\\Documentos\\csv (1)\\csv"));
    }

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
    protected String obtenerIdEntidad(Cotizante entidad) {
        return entidad.getCedula(); // Ajusta este método según cómo se obtenga el ID de Cotizante
    }
}
