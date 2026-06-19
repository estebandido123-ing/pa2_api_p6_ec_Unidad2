package Domain.Infraestructure.Repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import Domain.model.Libro;
import Domain.repository.LibroRepository;

@ApplicationScoped
@Transactional
public class LibroRepositoryImpl implements LibroRepository {
    @Inject private EntityManager em;

    @Override public void crear(Libro libro) { this.em.persist(libro); }
    @Override public Libro seleccionarPorId(Integer id) { return this.em.find(Libro.class, id); }
    @Override public void actualizar(Libro libro) { this.em.merge(libro); }
    @Override public void eliminar(Integer id) { 
        Libro l = this.seleccionarPorId(id);
        if (l != null) this.em.remove(l); 
    }
    @Override public List<Libro> seleccionarTodos() {
        return this.em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }
}
