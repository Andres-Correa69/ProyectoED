package proyecto.colpensionex.repository.csv;


import proyecto.colpensionex.repository.cache.SuperCache;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ArrayList;


public abstract class ADao<ClaseEntidad, TipoId> implements IDao<ClaseEntidad, TipoId> {

    private Class<ClaseEntidad> claseEntidad;
    private final List<GestorDeEntidad> gestoresDeEntidad = new ArrayList<>();
    private final SuperCache<ClaseEntidad, TipoId> superCache = new SuperCache<>();

    @SuppressWarnings("unchecked")
    public ADao(List<String> rutasArchivos) throws IOException {
        this.claseEntidad = (Class<ClaseEntidad>) (
                (ParameterizedType) getClass().getGenericSuperclass()
        ).getActualTypeArguments()[0];

        // Crear una instancia de GestorDeEntidad para cada archivo
        for (String ruta : rutasArchivos) {
            gestoresDeEntidad.add(new GestorDeEntidad(ruta));
        }
    }

    @Override
    public List<ClaseEntidad> obtenerTodos() {
        // Verifica si la caché está vacía; si es así, carga desde los archivos
        if (superCache.obtenerTodos().isEmpty()) {
            for (GestorDeEntidad gestor : gestoresDeEntidad) {
                List<ClaseEntidad> entidades = gestor.obtenerTodos(claseEntidad);
                superCache.cargarTodos(entidades, this::obtenerIdEntidad);
            }
        }
        return superCache.obtenerTodos(); // Devuelve la lista de entidades desde SuperCache
    }

    // Método abstracto para obtener el ID de la entidad, requerido por SuperCache
    protected abstract TipoId obtenerIdEntidad(ClaseEntidad entidad);

    // Método para limpiar el caché si es necesario
    public void limpiarCache() {
        superCache.limpiarCache();
    }
}
