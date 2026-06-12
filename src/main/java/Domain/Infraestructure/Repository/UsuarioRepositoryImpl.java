package Domain.Infraestructure.Repository;

import Domain.model.Usuario;
import Domain.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@ApplicationScoped
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Usuario usuario) { 
        this.em.persist(usuario); 
    }

    @Override
    public Usuario seleccionarPorId(Integer id) {
         return this.em.find(Usuario.class, id); 
        }

    @Override
    public void actualizar(Usuario usuario) {
         this.em.merge(usuario); 
        }

    @Override
    public void eliminar(Integer id) {
        Usuario u = this.seleccionarPorId(id);
        if (u != null) this.em.remove(u);
    }
}
