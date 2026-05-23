package uce.edu.ec.domain.respository;

import java.util.List;

import uce.edu.ec.domain.model.Estudiante;

public interface estudianteRepository {

    public void crear(Estudiante estudiante);  
    public Estudiante seleccionar (Integer id);
    public void actualizar(Estudiante estudiante);  
    public void eliminar(Integer id);  
    public Estudiante selectByNombre(String Nombre);

    public List<Estudiante> seleccionarTodos();

    List <Estudiante> seleccionarXNombre(String nombre);

    public Estudiante seleccionarXCedula(String cedula);
    



    
}
