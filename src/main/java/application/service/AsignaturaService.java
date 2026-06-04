package application.service;

import java.util.List;

import domain.model.Asignatura;
import domain.repository.AsignaturaRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AsignaturaService {



    private AsignaturaRepository asignaturaRepository;

    public void guardar (Asignatura asignatura){
        this.asignaturaRepository.crear(asignatura);
    }
    public void actualizar (Asignatura asignatura){
        this.asignaturaRepository.actualizar(asignatura);

    }
    public void eliminar (Integer Id){
        this.asignaturaRepository.eliminar(Id);

    }
     public Asignatura buscarPorId(Integer Id){
        return this.asignaturaRepository.seleccionarPorId(Id);

     }
     public List<Asignatura> consultarPorNivel(Integer nivel){
        return this.asignaturaRepository.consultarPorNivel(nivel);
     }
     public List<Asignatura> buscarPorNombreContiene(String texto){
        return this.asignaturaRepository.buscarPorNombreContiene(texto);
     }
     public Long contarTotal(){
        return this.asignaturaRepository.contarTotal();
     }


}
