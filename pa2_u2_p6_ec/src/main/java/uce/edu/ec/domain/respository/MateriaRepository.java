package uce.edu.ec.domain.respository;

import java.util.List;

import uce.edu.ec.domain.model.Materia;

public interface MateriaRepository {
    
    void crear(Materia materia);
    
    Materia seleccionarPorId(Integer id);
    
    void actualizar(Materia materia);
    
    void eliminar(Integer id);
    
    List<Materia> seleccionarTodos();

    Materia seleccionarPorIdConAlumnos(Integer id);
}
