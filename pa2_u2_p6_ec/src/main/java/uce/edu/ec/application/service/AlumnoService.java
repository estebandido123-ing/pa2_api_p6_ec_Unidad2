package uce.edu.ec.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Alumno;
import uce.edu.ec.domain.respository.AlumnoRepository;

@ApplicationScoped
public class AlumnoService {

    @Inject
    private AlumnoRepository alumnoRepository;

    public void guardar(Alumno alumno) {
        this.alumnoRepository.crear(alumno);
    }

    public Alumno buscarPorId(Integer id) {
        return this.alumnoRepository.seleccionarPorId(id);
    }

    public void actualizar(Alumno alumno) {
        this.alumnoRepository.actualizar(alumno);
    }

    public void eliminar(Integer id) {
        this.alumnoRepository.eliminar(id);
    }

    public List<Alumno> buscarTodos() {
        return this.alumnoRepository.seleccionarTodos();
    }
}
