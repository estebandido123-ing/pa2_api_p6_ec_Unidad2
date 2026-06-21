package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Proyecto;
import Domain.repository.ProyectoRepository;

@ApplicationScoped
public class ProyectoService {
    @Inject private ProyectoRepository proyectoRepository;

    public void guardar(Proyecto proyecto) {
         this.proyectoRepository.crear(proyecto); }
    public Proyecto buscarPorId(Integer id) {
         return this.proyectoRepository.seleccionarPorId(id); }
    public void actualizar(Proyecto proyecto) {
         this.proyectoRepository.actualizar(proyecto); }
    public void eliminar(Integer id) {
         this.proyectoRepository.eliminar(id); }
    public List<Proyecto> buscarTodos() {
         return this.proyectoRepository.seleccionarTodos(); }
    public Proyecto buscarPorIdConDesarrolladores(Integer id) {
         return this.proyectoRepository.seleccionarPorIdConDesarrolladores(id); }
}