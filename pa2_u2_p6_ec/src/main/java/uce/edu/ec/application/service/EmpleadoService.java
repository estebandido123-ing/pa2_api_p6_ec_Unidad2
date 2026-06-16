package uce.edu.ec.application.service;
import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Ciudadano;
import uce.edu.ec.domain.model.Empleado;
import uce.edu.ec.domain.respository.EmpleadoRepository;

@ApplicationScoped

public class EmpleadoService {

    @Inject
    private EmpleadoRepository empleadoRepository;

    public void Insertar(Empleado empleado){
        /*
        Ciudadano ciudadanoNuevo = new Ciudadano();
        ciudadanoNuevo.setNombre("Luis Mideros");
        ciudadanoNuevo.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        ciudadanoNuevo.setNombre("axel");
        empleado.setCiudadano(ciudadanoNuevo);
        this.empleadoRepository.crear(empleado);
        */
    }

    public void guardar(Empleado empleado) {
        this.empleadoRepository.crear(empleado);
    }

    public Empleado buscarPorId(Integer id) {
        return this.empleadoRepository.seleccionarPorId(id);
    }

    public void actualizar(Empleado empleado) {
        this.empleadoRepository.actualizar(empleado);
    }

    public void eliminar(Integer id) {
        this.empleadoRepository.eliminar(id);
    }


}


