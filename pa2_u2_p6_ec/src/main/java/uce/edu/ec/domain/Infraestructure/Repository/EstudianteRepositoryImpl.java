package uce.edu.ec.domain.Infraestructure.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.respository.estudianteRepository;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements estudianteRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        return this.em.find(Estudiante.class, id);

    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionar(id));
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return miQuery.getResultList();        
    }

    @Override
    public Estudiante selectByNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombreBuscado", Estudiante.class);
        miQuery.setParameter("nombreBuscado", nombre);
        return miQuery.getSingleResult();        
    }

    @Override
    public List<Estudiante> seleccionarXNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre1", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarXCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class);
        miQuery.setParameter("cedula", cedula);

        //return miQuery.getSingleResult();
        //return miQuery.getResultList().get(0);
        return miQuery.getResultList().getFirst();

    }


    


}
