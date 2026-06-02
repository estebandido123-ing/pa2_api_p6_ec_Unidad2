package uce.edu.ec.domain.respository;

import java.time.LocalDate;
import java.util.List;

import uce.edu.ec.domain.model.Estudiante;

public interface estudianteRepository {
    //implemento los metodos que voy a necesitar para realizar EL CRUD
    public void crear(Estudiante estudiante);
    public Estudiante seleccionarPorId(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);
    public List<Estudiante> seleccionarTodos();
    public List<Estudiante> seleccionarPorNombre(String nombre);
    public Estudiante seleccionarPorCedula(String cedula);
    //1.2 NamedQuery
    public List<Estudiante> seleccionarPorGenero(String genero);
    public List<Estudiante> seleccionarPorGeneroTyped(String genero);
    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin);
    public Long contar();

    //Native QUERY
    public List<Estudiante> seleccionarTodosNative();

    public List<Estudiante> seleccionarTodosCriteria();


    public List<Estudiante> seleccionarPorNombreCriteria(String nombre);


    public List<Estudiante> seleccionarDinamicoCriteria(String nombre, String apellido);

    
}
