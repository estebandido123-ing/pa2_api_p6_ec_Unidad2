package Domain.Infraestructure.Repository;

import java.util.List;

import Domain.model.Actor;
import Domain.repository.ActorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class ActorRepositoryImpl implements ActorRepository {
    @Inject private EntityManager em;

    @Override 
    public void crear(Actor actor) {
         this.em.persist(actor); }
    @Override 
    public Actor seleccionarPorId(Integer id) {
         return this.em.find(Actor.class, id); }
    @Override 
    public void actualizar(Actor actor) {
         this.em.merge(actor); }
    @Override 
    public void eliminar(Integer id) { 
        Actor a = this.seleccionarPorId(id);
        if (a != null) this.em.remove(a); 
    }
    @Override public List<Actor> seleccionarTodos() {
        return this.em.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
    }
}
