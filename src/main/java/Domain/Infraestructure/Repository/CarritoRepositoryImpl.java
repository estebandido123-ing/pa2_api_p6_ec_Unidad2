package Domain.Infraestructure.Repository;

import Domain.model.Carrito;
import Domain.repository.CarritoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class CarritoRepositoryImpl implements CarritoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Carrito carrito) { 
        this.em.persist(carrito); 
    }

    @Override
    public Carrito seleccionarPorId(Integer id) { 
        return this.em.find(Carrito.class, id); 
    }

    @Override
    public void actualizar(Carrito carrito) { 
        this.em.merge(carrito); 
    }

    @Override
    public void eliminar(Integer id) {
        Carrito c = this.seleccionarPorId(id);
        if (c != null) this.em.remove(c);
    }
}
