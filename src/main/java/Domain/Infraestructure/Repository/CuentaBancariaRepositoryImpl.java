package Domain.Infraestructure.Repository;

import java.util.List;

import Domain.model.CuentaBancaria;
import Domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(CuentaBancaria cuentaBancaria) {
        this.em.persist(cuentaBancaria);
    }

    @Override
    public CuentaBancaria seleccionarPorId(Integer id) {
        return this.em.find(CuentaBancaria.class, id);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.em.merge(cuentaBancaria);
    }

    @Override
    public void eliminar(Integer id) {
        CuentaBancaria cuentaBancaria = this.seleccionarPorId(id);
        if (cuentaBancaria != null) {
            this.em.remove(cuentaBancaria);
        }
    }

    @Override
    public List<CuentaBancaria> seleccionarTodos() {
        TypedQuery<CuentaBancaria> query = this.em.createQuery("SELECT c FROM CuentaBancaria c", CuentaBancaria.class);
        return query.getResultList();
    }
}
