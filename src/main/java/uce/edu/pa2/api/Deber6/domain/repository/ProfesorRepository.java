package uce.edu.pa2.api.Deber6.domain.repository;

import java.time.LocalDate;
import java.util.List;

import uce.edu.pa2.api.Deber6.domain.model.Profesor;

public interface ProfesorRepository {
    
    public void crear(Profesor profesor);
    public Profesor seleccionarPorId(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);
    public List<Profesor> seleccionarTodos();
    public List<Profesor> seleccionarPorNombre(String nombre);
    public Profesor seleccionarPorCedula(String cedula);
    
    // 1.2 NamedQuery
    public List<Profesor> seleccionarPorDepartamento(String departamento);
    public List<Profesor> seleccionarPorDepartamentoTyped(String departamento);
    public List<Profesor> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin);
    public Long contar();

    // Native QUERY
    public List<Profesor> seleccionarTodosNative();

    // Criteria API
    public List<Profesor> seleccionarTodosCriteria();
    public List<Profesor> seleccionarPorNombreCriteria(String nombre);
    public List<Profesor> seleccionarDinamicoCriteria(String nombre, String apellido);

    
}
