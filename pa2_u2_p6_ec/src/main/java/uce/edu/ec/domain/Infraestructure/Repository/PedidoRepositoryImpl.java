package uce.edu.ec.domain.Infraestructure.Repository;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Pedido;
import uce.edu.ec.domain.respository.PedidoRepository;

@ApplicationScoped
@Transactional
public class PedidoRepositoryImpl implements PedidoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Pedido pedido) {
        this.em.persist(pedido);
    }

    @Override
    public Pedido seleccionarPorId(Integer id) {
        return this.em.find(Pedido.class, id);
    }

    @Override
    public void actualizar(Pedido pedido) {
        this.em.merge(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        Pedido pedido = this.seleccionarPorId(id);
        if (pedido != null) {
            this.em.remove(pedido);
        }
    }
    @Override
    public List<Pedido> seleccionarTodos() {
        TypedQuery<Pedido> query = this.em.createQuery("SELECT p FROM Pedido p", Pedido.class);
        return query.getResultList();
    }
}
