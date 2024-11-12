package proyecto.colpensionex.repository.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SuperCache<ClaseEntidad, TipoId> {

    // Un mapa que actúa como caché para almacenar entidades con su ID como clave
    private final Map<TipoId, ClaseEntidad> cache = new HashMap<>();

    /**
     * Carga una lista completa de entidades en la caché.
     * Recorre cada entidad en la lista, extrae su ID y la almacena en el mapa de caché.
     *
     * @param entidades Lista de entidades que se desea cargar en la caché.
     * @param idExtractor Interfaz funcional para extraer el ID de cada entidad.
     */
    public void cargarTodos(List<ClaseEntidad> entidades, CacheIdExtractor<ClaseEntidad, TipoId> idExtractor) {
        for (ClaseEntidad entidad : entidades) {
            TipoId id = idExtractor.extractId(entidad);  // Extrae el ID de la entidad
            cache.put(id, entidad);  // Almacena la entidad en el mapa de caché con su ID como clave
        }
    }

    /**
     * Obtiene una entidad de la caché usando su ID.
     *
     * @param id El ID de la entidad a buscar en la caché.
     * @return La entidad correspondiente si existe, envuelta en un Optional; de lo contrario, Optional vacío.
     */
    public Optional<ClaseEntidad> obtenerPorId(TipoId id) {
        return Optional.ofNullable(cache.get(id));  // Busca en el mapa de caché y devuelve el resultado como Optional
    }

    /**
     * Agrega o actualiza una entidad en la caché.
     *
     * @param id El ID de la entidad que se agrega o actualiza.
     * @param entidad La entidad que se almacena o actualiza en la caché.
     */
    public void agregarOActualizar(TipoId id, ClaseEntidad entidad) {
        cache.put(id, entidad);  // Agrega o reemplaza la entidad en el caché
    }

    /**
     * Elimina una entidad de la caché.
     *
     * @param id El ID de la entidad que se desea eliminar.
     * @return true si la entidad fue eliminada, false si no estaba en la caché.
     */
    public boolean eliminar(TipoId id) {
        return cache.remove(id) != null;  // Elimina la entidad y devuelve true si existía
    }

    /**
     * Obtiene todas las entidades almacenadas en la caché.
     *
     * @return Una lista de todas las entidades almacenadas en la caché.
     */
    public List<ClaseEntidad> obtenerTodos() {
        return List.copyOf(cache.values());  // Devuelve una copia inmutable de la lista de valores del caché
    }

    /**
     * Vacía la caché, eliminando todas las entidades almacenadas.
     */
    public void limpiarCache() {
        cache.clear();  // Limpia todos los datos en el caché
    }

    /**
     * Interfaz funcional utilizada para extraer el ID de una entidad específica.
     * Define un método lambda que toma una entidad y devuelve su ID.
     *
     * @param <ClaseEntidad> El tipo de la entidad.
     * @param <TipoId> El tipo del ID de la entidad.
     */
    @FunctionalInterface
    public interface CacheIdExtractor<ClaseEntidad, TipoId> {
        TipoId extractId(ClaseEntidad entidad);  // Método para extraer el ID de una entidad
    }
}
