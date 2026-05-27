package uce.edu.pa2.api.Deber6.domain.infraEstructure.repositoryProfe;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override
    public Profesor seleccionar(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionar(id));
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return miQuery.getResultList();        
    }

    @Override
    public Profesor selectByNombre(String nombre) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombreBuscado", Profesor.class);
        miQuery.setParameter("nombreBuscado", nombre);
        return miQuery.getSingleResult();        
    }

    @Override
    public List<Profesor> seleccionarXNombre(String nombre) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre1", Profesor.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Profesor seleccionarXCedula(String cedula) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula", Profesor.class);
        miQuery.setParameter("cedula", cedula);
        return miQuery.getResultList().getFirst();
    }
}
