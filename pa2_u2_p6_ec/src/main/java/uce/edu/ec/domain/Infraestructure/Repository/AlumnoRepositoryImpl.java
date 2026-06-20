package uce.edu.ec.domain.Infraestructure.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Alumno;
import uce.edu.ec.domain.respository.AlumnoRepository;

@ApplicationScoped
@Transactional
public class AlumnoRepositoryImpl implements AlumnoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Alumno alumno) {
        this.em.persist(alumno);
    }

    @Override
    public Alumno seleccionarPorId(Integer id) {
        return this.em.find(Alumno.class, id);
    }

    @Override
    public void actualizar(Alumno alumno) {
        this.em.merge(alumno);
    }

    @Override
    public void eliminar(Integer id) {
        Alumno alumno = this.seleccionarPorId(id);
        if (alumno != null) {
            this.em.remove(alumno);
        }
    }

    @Override
    public List<Alumno> seleccionarTodos() {
        TypedQuery<Alumno> query = this.em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        return query.getResultList();
    }

    @Override
    public Alumno seleccionarPorIdConMaterias(Integer id) {
        jakarta.persistence.TypedQuery<Alumno> query = this.em.createQuery(
            "SELECT a FROM Alumno a LEFT JOIN FETCH a.materias WHERE a.Id = :idAlumno", Alumno.class);
        query.setParameter("idAlumno", id);
        
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null; 
    }
}
}