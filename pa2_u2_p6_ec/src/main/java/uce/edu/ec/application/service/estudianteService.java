package uce.edu.ec.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.respository.estudianteRepository;

@ApplicationScoped
@Transactional
public class estudianteService {

    @Inject
    private EntityManager em;

    @Inject
    private estudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante) {
        this.em.persist(estudiante);    
    }

    public Estudiante buscarXId(Integer id) {
        return em.find(Estudiante.class, id);
    }

    public void actualizar(Estudiante estudiante) {
        em.merge(estudiante);
    }

    public void eliminar(Integer id) {
        Estudiante estudianteAEliminar = em.find(Estudiante.class, id);
        
        if (estudianteAEliminar != null) {
            em.remove(estudianteAEliminar);
        }
    }

    public List<Estudiante> seleccionarTodos() {
        return estudianteRepository.seleccionarTodos();
    }


    public Estudiante selectByNombre(String nombre) {
        return estudianteRepository.selectByNombre(nombre);
    }

    public List<Estudiante> seleccionarXNombre(String nombre) {
        return estudianteRepository.seleccionarXNombre(nombre);
    }

    public Estudiante seleccionarXCedula(String cedula) {
        return estudianteRepository.seleccionarXCedula(cedula);
    }


}
