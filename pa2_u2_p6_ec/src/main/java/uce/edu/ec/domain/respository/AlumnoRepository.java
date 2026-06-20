package uce.edu.ec.domain.respository;

import java.util.List;

import uce.edu.ec.domain.model.Alumno;

public interface AlumnoRepository {
    
    void crear(Alumno alumno);
    
    Alumno seleccionarPorId(Integer id);
    
    void actualizar(Alumno alumno);
    
    void eliminar(Integer id);
    
    List<Alumno> seleccionarTodos();

    Alumno seleccionarPorIdConMaterias(Integer id);
}
