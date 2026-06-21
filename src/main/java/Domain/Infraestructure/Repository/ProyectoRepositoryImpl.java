package Domain.Infraestructure.Repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import Domain.model.Proyecto;
import Domain.repository.ProyectoRepository;

@ApplicationScoped
@Transactional
public class ProyectoRepositoryImpl implements ProyectoRepository {
    @Inject private EntityManager em;

    @Override public void crear(Proyecto proyecto) {
         this.em.persist(proyecto); }
    @Override public Proyecto seleccionarPorId(Integer id) {
         return this.em.find(Proyecto.class, id); }
    @Override public void actualizar(Proyecto proyecto) {
         this.em.merge(proyecto); }
    @Override public void eliminar(Integer id) { 
        Proyecto p = this.seleccionarPorId(id);
        if (p != null) this.em.remove(p); 
    }
    @Override public List<Proyecto> seleccionarTodos() {
        return this.em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
    }
    
    @Override
    public Proyecto seleccionarPorIdConDesarrolladores(Integer id) {
        try {
            return this.em.createQuery("SELECT p FROM Proyecto p LEFT JOIN FETCH p.desarrolladores WHERE p.id = :idProyecto", Proyecto.class)
                          .setParameter("idProyecto", id)
                          .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) { return null; }
    }
}