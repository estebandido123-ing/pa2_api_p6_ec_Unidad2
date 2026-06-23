package Application.service;

import java.util.List;

import Domain.model.Transferencia;
import Domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class TransferenciaService {

    @Inject
    private TransferenciaRepository transferenciaRepository;

    public void guardar(Transferencia transferencia) {
        this.transferenciaRepository.crear(transferencia);
    }

    public Transferencia buscarPorId(Integer id) {
        return this.transferenciaRepository.seleccionarPorId(id);
    }

    public void actualizar(Transferencia transferencia) {
        this.transferenciaRepository.actualizar(transferencia);
    }

    public void eliminar(Integer id) {
        this.transferenciaRepository.eliminar(id);
    }

    public List<Transferencia> buscarTodos() {
        return this.transferenciaRepository.seleccionarTodos();
    }
}
