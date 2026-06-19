package Domain.Infraestructure.Repository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import Domain.model.Autor;
import Domain.repository.AutorRepository;

@ApplicationScoped
@Transactional
public class AutorRepositoryImpl implements AutorRepository {
    @Inject private EntityManager em;

    @Override public void crear(Autor autor) { this.em.persist(autor); }
    @Override public Autor seleccionarPorId(Integer id) { return this.em.find(Autor.class, id); }
    @Override public void actualizar(Autor autor) { this.em.merge(autor); }
    @Override public void eliminar(Integer id) { 
        Autor a = this.seleccionarPorId(id);
        if (a != null) this.em.remove(a); 
    }
    @Override public List<Autor> seleccionarTodos() {
        return this.em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
    }
}
