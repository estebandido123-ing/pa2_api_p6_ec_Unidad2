package uce.edu.pa2.api.Deber6.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
//import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;
import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;

@ApplicationScoped
@Transactional
public class ProfesorService {

    @Inject
    private EntityManager em;

    @Inject
    private ProfesorRepository profesorRepository;

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

    public List<Profesor> seleccionarTodos() {
        return profesorRepository.seleccionarTodos();
    }

    public Profesor selectByNombre(String nombre) {
        return profesorRepository.selectByNombre(nombre);
    }

    public List<Profesor> seleccionarXNombre(String nombre) {
        return profesorRepository.seleccionarXNombre(nombre);
    }

    public Profesor seleccionarXCedula(String cedula) {
        return profesorRepository.seleccionarXCedula(cedula);
    }
}
