package Domain.repository;

import java.util.List;
import Domain.model.Proyecto;

public interface ProyectoRepository {
    void crear(Proyecto proyecto);
    Proyecto seleccionarPorId(Integer id);
    void actualizar(Proyecto proyecto);
    void eliminar(Integer id);
    List<Proyecto> seleccionarTodos();
    Proyecto seleccionarPorIdConDesarrolladores(Integer id);
}
