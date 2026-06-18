package uce.edu.ec.domain.Infraestructure.Repository;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Cliente;
import uce.edu.ec.domain.respository.ClienteRepository;

@ApplicationScoped
@Transactional
public class ClienteRepositoryImpl implements ClienteRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Cliente cliente) {
        this.em.persist(cliente);
    }

    @Override
    public Cliente seleccionarPorId(Integer id) {
        return this.em.find(Cliente.class, id);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.em.merge(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        Cliente cliente = this.seleccionarPorId(id);
        if (cliente != null) {
            this.em.remove(cliente);
        }
    }

    @Override
    public List<Cliente> seleccionarTodos() {
        TypedQuery<Cliente> query = this.em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }
}
