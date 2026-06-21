package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Desarrollador;
import Domain.repository.DesarrolladorRepository;

@ApplicationScoped
public class DesarrolladorService {
    @Inject private DesarrolladorRepository desarrolladorRepository;

    public void guardar(Desarrollador desarrollador) {
         this.desarrolladorRepository.crear(desarrollador); 
        }
    public Desarrollador buscarPorId(Integer id) {
         return this.desarrolladorRepository.seleccionarPorId(id); 
        }
    public void actualizar(Desarrollador desarrollador) {
         this.desarrolladorRepository.actualizar(desarrollador); 
        }
    public void eliminar(Integer id) {
         this.desarrolladorRepository.eliminar(id); 
        }
    public List<Desarrollador> buscarTodos() {
         return this.desarrolladorRepository.seleccionarTodos(); 
        }
    public Desarrollador buscarPorIdConProyectos(Integer id) {
         return this.desarrolladorRepository.seleccionarPorIdConProyectos(id); 
        }
}
