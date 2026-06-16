package uce.edu.ec.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Ciudadano;
import uce.edu.ec.domain.respository.CiudadanoRepository;

@ApplicationScoped
public class CiudadanoService {

    @Inject
    private CiudadanoRepository ciudadanoRepository;

    

    public void guardar(Ciudadano ciudadano) {
        this.ciudadanoRepository.crear(ciudadano);
    }

    public Ciudadano buscarPorId(Integer id) {
        return this.ciudadanoRepository.seleccionarPorId(id);
    }

    public void actualizar(Ciudadano ciudadano) {
        this.ciudadanoRepository.actualizar(ciudadano);
    }

    public void eliminar(Integer id) {
        this.ciudadanoRepository.eliminar(id);
    }
}
