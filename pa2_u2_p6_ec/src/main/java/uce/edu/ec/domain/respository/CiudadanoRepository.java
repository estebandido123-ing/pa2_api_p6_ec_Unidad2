package uce.edu.ec.domain.respository;


import uce.edu.ec.domain.model.Ciudadano;

public interface CiudadanoRepository {
    void crear(Ciudadano ciudadano);
    Ciudadano seleccionarPorId(Integer id);
    void actualizar(Ciudadano ciudadano);
    void eliminar(Integer id);
}