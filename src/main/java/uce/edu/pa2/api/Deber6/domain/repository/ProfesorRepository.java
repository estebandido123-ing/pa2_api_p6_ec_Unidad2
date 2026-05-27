package uce.edu.pa2.api.Deber6.domain.repository;

import java.util.List;

import uce.edu.pa2.api.Deber6.domain.model.Profesor;

public interface ProfesorRepository {
    
    public void crear(Profesor profesor);  
    public Profesor seleccionar(Integer id);
    public void actualizar(Profesor profesor);  
    public void eliminar(Integer id);  
    
    public Profesor selectByNombre(String nombre);
    public List<Profesor> seleccionarTodos();
    public List<Profesor> seleccionarXNombre(String nombre);
    public Profesor seleccionarXCedula(String cedula);
}
