package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Actor;
import Domain.repository.ActorRepository;

@ApplicationScoped
public class ActorService {
    @Inject private ActorRepository actorRepository;

    public void guardar(Actor actor) {
         this.actorRepository.crear(actor); }
    public Actor buscarPorId(Integer id) {
         return this.actorRepository.seleccionarPorId(id); }
    public void actualizar(Actor actor) {
         this.actorRepository.actualizar(actor); }
    public void eliminar(Integer id) {
         this.actorRepository.eliminar(id); }
    public List<Actor> buscarTodos() {
         return this.actorRepository.seleccionarTodos(); }
}