package uce.edu.ec.application.service;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.respository.estudianteRepository;


//@Transactional
//Aqui programamos toda la logica de negocio 
@ApplicationScoped
public class estudianteService {

    @Inject
    private estudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);

    }

    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);;

    }

    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);

    }
    
    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);

    }
    public List<Estudiante> buscarTodos(){
        return this.estudianteRepository.seleccionarTodos();
    }

    public List<Estudiante> buscarPorNombre(String nombre){
        return this.estudianteRepository.seleccionarPorNombre(nombre);
    }

    public Estudiante buscarPorCedula(String cedula){
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }

    public List<Estudiante> buscarPorGenero(String genero){
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }

     public List<Estudiante> buscarPorGeneroTyped(String genero){
        return this.estudianteRepository.seleccionarPorGeneroTyped(genero);
     }
     public List<Estudiante>buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin){
        return this.estudianteRepository.seleccionarPorRangoFecha(fechaInicio, fechaFin);
     }

     public Long contar(){
        return this.estudianteRepository.contar();
     }

     public List<Estudiante> buscarTodosNative(){
        return this.estudianteRepository.seleccionarTodosNative();
     }

     public List<Estudiante> buscarTodosCriteria(){
        return this.estudianteRepository.seleccionarTodosCriteria();
     }

     public List<Estudiante> buscarPorNombreCriteria(String Nombre){
        return this.estudianteRepository.seleccionarPorNombreCriteria(Nombre);
     }

     public List<Estudiante> buscarDinamicoCriteria(String nombre, String apellido) {
        return this.estudianteRepository.seleccionarDinamicoCriteria(nombre, apellido);
    }

}
