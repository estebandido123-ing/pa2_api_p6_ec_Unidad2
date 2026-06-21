package Domain.Infraestructure.Repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import Domain.model.Desarrollador;
import Domain.repository.DesarrolladorRepository;

@ApplicationScoped
@Transactional
public class DesarrolladorRepositoryImpl implements DesarrolladorRepository {
    @Inject private EntityManager em;

    @Override public void crear(Desarrollador desarrollador) {
         this.em.persist(desarrollador); 
        }
    @Override public Desarrollador seleccionarPorId(Integer id) {
         return this.em.find(Desarrollador.class, id); 
        }
    @Override public void actualizar(Desarrollador desarrollador) {
         this.em.merge(desarrollador); 
        }
    @Override public void eliminar(Integer id) { 
        Desarrollador d = this.seleccionarPorId(id);
        if (d != null) this.em.remove(d); 
    }
    @Override public List<Desarrollador> seleccionarTodos() {
        return this.em.createQuery("SELECT d FROM Desarrollador d", Desarrollador.class).getResultList();
    }

    @Override
    public Desarrollador seleccionarPorIdConProyectos(Integer id) {
        try {
            return this.em.createQuery("SELECT d FROM Desarrollador d LEFT JOIN FETCH d.proyectos WHERE d.id = :idDev", Desarrollador.class)
                          .setParameter("idDev", id)
                          .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) { return null; }
    }
}