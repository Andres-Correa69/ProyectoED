package proyecto.colpensionex.repository.csv;

import java.util.List;

public interface IDao <ClaseEntidad, tipoId>{

    public List<ClaseEntidad> obtenerTodos();
}
