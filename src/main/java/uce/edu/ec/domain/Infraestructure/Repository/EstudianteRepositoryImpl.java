package uce.edu.ec.domain.Infraestructure.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
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

}
