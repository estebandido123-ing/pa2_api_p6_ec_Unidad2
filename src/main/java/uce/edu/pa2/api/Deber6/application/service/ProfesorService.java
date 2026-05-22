package uce.edu.pa2.api.Deber6.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
//import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;

@ApplicationScoped
@Transactional
public class ProfesorService {

    @Inject
    private EntityManager em;

    //@Inject
    //private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor) {
        this.em.persist(profesor);
    }

    public Profesor buscarXId(Integer id) {
        return em.find(Profesor.class, id);
    }

    public void actualizar(Profesor profesor) {
        em.merge(profesor);
    }

    public void eliminar(Integer id) {
        Profesor profesorAEliminar = em.find(Profesor.class, id);
        
        if (profesorAEliminar != null) {
            em.remove(profesorAEliminar);
        }
    }
}
