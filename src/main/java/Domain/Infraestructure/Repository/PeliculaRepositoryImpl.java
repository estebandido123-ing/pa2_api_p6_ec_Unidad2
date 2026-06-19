package Domain.Infraestructure.Repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import Domain.model.Pelicula;
import Domain.repository.PeliculaRepository;

@ApplicationScoped
@Transactional
public class PeliculaRepositoryImpl implements PeliculaRepository {
    @Inject private EntityManager em;

    @Override public void crear(Pelicula pelicula) { this.em.persist(pelicula); }
    @Override public Pelicula seleccionarPorId(Integer id) { return this.em.find(Pelicula.class, id); }
    @Override public void actualizar(Pelicula pelicula) { this.em.merge(pelicula); }
    @Override public void eliminar(Integer id) { 
        Pelicula p = this.seleccionarPorId(id);
        if (p != null) this.em.remove(p); 
    }
    @Override public List<Pelicula> seleccionarTodos() {
        return this.em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
    }
}
