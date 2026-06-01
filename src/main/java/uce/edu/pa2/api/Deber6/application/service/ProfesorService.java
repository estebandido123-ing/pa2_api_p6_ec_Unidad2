package uce.edu.pa2.api.Deber6.application.service;

import java.time.LocalDate;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
//import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;
import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor){
        this.profesorRepository.crear(profesor);
    }

    public void eliminar(Integer id){
        this.profesorRepository.eliminar(id);
    }

    public Profesor buscarPorId(Integer id){
        return this.profesorRepository.seleccionarPorId(id);
    }
    
    public void actualizar(Profesor profesor){
        this.profesorRepository.actualizar(profesor);
    }

    public List<Profesor> buscarTodos(){
        return this.profesorRepository.seleccionarTodos();
    }

    public List<Profesor> buscarPorNombre(String nombre){
        return this.profesorRepository.seleccionarPorNombre(nombre);
    }

    public Profesor buscarPorCedula(String cedula){
        return this.profesorRepository.seleccionarPorCedula(cedula);
    }

    public List<Profesor> buscarPorDepartamento(String departamento){
        return this.profesorRepository.seleccionarPorDepartamento(departamento);
    }

     public List<Profesor> buscarPorDepartamentoTyped(String departamento){
        return this.profesorRepository.seleccionarPorDepartamentoTyped(departamento);
     }

     public List<Profesor> buscarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin){
        return this.profesorRepository.seleccionarPorRangoFecha(fechaInicio, fechaFin);
     }

     public Long contar(){
        return this.profesorRepository.contar();
     }
}
