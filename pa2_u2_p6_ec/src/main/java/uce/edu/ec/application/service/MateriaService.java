package uce.edu.ec.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Materia;
import uce.edu.ec.domain.respository.MateriaRepository;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public void guardar(Materia materia) {
        this.materiaRepository.crear(materia);
    }

    public Materia buscarPorId(Integer id) {
        return this.materiaRepository.seleccionarPorId(id);
    }

    public void actualizar(Materia materia) {
        this.materiaRepository.actualizar(materia);
    }

    public void eliminar(Integer id) {
        this.materiaRepository.eliminar(id);
    }

    public List<Materia> buscarTodos() {
        return this.materiaRepository.seleccionarTodos();
    }

    public Materia buscarPorIdConAlumnos(Integer id) {
        return this.materiaRepository.seleccionarPorIdConAlumnos(id);
    }

}