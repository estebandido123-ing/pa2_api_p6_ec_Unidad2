package uce.edu.ec.domain.respository;

import uce.edu.ec.domain.model.Empleado;

public interface EmpleadoRepository {
    void crear(Empleado empleado);
    Empleado seleccionarPorId(Integer id);
    void actualizar(Empleado empleado);
    void eliminar(Integer id);
}