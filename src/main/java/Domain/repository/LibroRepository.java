package Domain.repository;

import java.util.List;
import Domain.model.Libro;

public interface LibroRepository {
    void crear(Libro libro);
    Libro seleccionarPorId(Integer id);
    void actualizar(Libro libro);
    void eliminar(Integer id);
    List<Libro> seleccionarTodos();
}
