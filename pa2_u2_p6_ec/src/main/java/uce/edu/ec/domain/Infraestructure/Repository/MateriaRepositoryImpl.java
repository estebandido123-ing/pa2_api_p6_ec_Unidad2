package uce.edu.ec.domain.Infraestructure.Repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Materia;
import uce.edu.ec.domain.respository.MateriaRepository;

@ApplicationScoped
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Materia materia) {
        this.em.persist(materia);
    }

    @Override
    public Materia seleccionarPorId(Integer id) {
        return this.em.find(Materia.class, id);
    }

    @Override
    public void actualizar(Materia materia) {
        this.em.merge(materia);
    }

    @Override
    public void eliminar(Integer id) {
        Materia materia = this.seleccionarPorId(id);
        if (materia != null) {
            this.em.remove(materia);
        }
    }

    @Override
    public List<Materia> seleccionarTodos() {
        TypedQuery<Materia> query = this.em.createQuery("SELECT m FROM Materia m", Materia.class);
        return query.getResultList();
    }
    
    @Override
    public Materia seleccionarPorIdConAlumnos(Integer id) {
        jakarta.persistence.TypedQuery<Materia> query = this.em.createQuery(
            "SELECT m FROM Materia m LEFT JOIN FETCH m.alumnos WHERE m.Id = :idMateria", Materia.class);
        query.setParameter("idMateria", id);
        
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null; // Retorna null si no encuentra la materia con ese ID
        }
    }

}
