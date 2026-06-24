package Domain.Infraestructure.Repository;

import java.util.List;

import Domain.model.Transferencia;
import Domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Transferencia transferencia) {
        this.em.persist(transferencia);
    }

    @Override
    public Transferencia seleccionarPorId(Integer id) {
        return this.em.find(Transferencia.class, id);
    }

    @Override
    public void actualizar(Transferencia transferencia) {
        this.em.merge(transferencia);
    }

    @Override
    public void eliminar(Integer id) {
        Transferencia transferencia = this.seleccionarPorId(id);
        if (transferencia != null) {
            this.em.remove(transferencia);
        }
    }

    @Override
    public List<Transferencia> seleccionarTodos() {
        TypedQuery<Transferencia> query = this.em.createQuery("SELECT t FROM Transferencia t", Transferencia.class);
        return query.getResultList();
    }
}