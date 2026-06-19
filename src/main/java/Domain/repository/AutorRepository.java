package Domain.repository;

import java.util.List;
import Domain.model.Autor;

public interface AutorRepository {
    void crear(Autor autor);
    Autor seleccionarPorId(Integer id);
    void actualizar(Autor autor);
    void eliminar(Integer id);
    List<Autor> seleccionarTodos();
}
