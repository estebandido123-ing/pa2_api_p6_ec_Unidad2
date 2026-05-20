package uce.edu.ec.domain.respository;

import uce.edu.ec.domain.model.Estudiante;

public interface estudianteRepository {

    public void crear(Estudiante estudiante);  
    public Estudiante seleccionar (Integer id);
    public void actualizar(Estudiante estudiante);  
    public void eliminar(Integer id);  

    
}
