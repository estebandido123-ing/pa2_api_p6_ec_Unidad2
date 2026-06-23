package Domain.repository;
import java.util.List;

import Domain.model.Transferencia;

public interface TransferenciaRepository {
    void crear(Transferencia transferencia);
    Transferencia seleccionarPorId(Integer id);
    void actualizar(Transferencia transferencia);
    void eliminar(Integer id);
    List<Transferencia> seleccionarTodos();
}