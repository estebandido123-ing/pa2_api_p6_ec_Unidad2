package domain.repository;

import java.util.List;

import domain.model.Asignatura;

public interface AsignaturaRepository {

    public void crear(Asignatura asignatura);
    public Asignatura seleccionarPorId(Integer Id);
    public void actualizar (Asignatura asignatura);
    public void eliminar (Integer id);

    public List<Asignatura> consultarPorNivel (Integer nivel);
    public List<Asignatura> buscarPorNombreContiene (String texto);
    public Long contarTotal();

}
