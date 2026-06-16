package uce.edu.ec.domain.Infraestructure.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Empleado;
import uce.edu.ec.domain.respository.EmpleadoRepository;

@ApplicationScoped
@Transactional
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Empleado empleado) {
        this.em.persist(empleado);
    }

    @Override
    public Empleado seleccionarPorId(Integer id) {
        return this.em.find(Empleado.class, id);
    }

    @Override
    public void actualizar(Empleado empleado) {
        this.em.merge(empleado);
    }

    @Override
    public void eliminar(Integer id) {
        Empleado empleado = this.seleccionarPorId(id);
        if (empleado != null) {
            this.em.remove(empleado);
        }
    }
}