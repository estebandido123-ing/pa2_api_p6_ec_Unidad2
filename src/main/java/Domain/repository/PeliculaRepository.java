package Domain.repository;

import java.util.List;
import Domain.model.Pelicula;

public interface PeliculaRepository {
    void crear(Pelicula pelicula);
    Pelicula seleccionarPorId(Integer id);
    void actualizar(Pelicula pelicula);
    void eliminar(Integer id);
    List<Pelicula> seleccionarTodos();
}