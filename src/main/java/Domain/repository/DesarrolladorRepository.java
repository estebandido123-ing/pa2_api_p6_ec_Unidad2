package Domain.repository;

import java.util.List;
import Domain.model.Desarrollador;

public interface DesarrolladorRepository {
    void crear(Desarrollador desarrollador);
    Desarrollador seleccionarPorId(Integer id);
    void actualizar(Desarrollador desarrollador);
    void eliminar(Integer id);
    List<Desarrollador> seleccionarTodos();
    Desarrollador seleccionarPorIdConProyectos(Integer id);
}
