package infraestructure.repository;

import java.util.List;

import javax.sound.midi.Sequence;

import com.mysql.cj.Query;

import domain.model.Asignatura;
import domain.repository.AsignaturaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AsignaturaRepositoryImpl implements AsignaturaRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Asignatura asignatura) {
        this.em.persist(asignatura);
        
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Asignatura seleccionarPorId(Integer Id) {
        return this.em.find(Asignatura.class, Id);
    }

    @Override
    public void actualizar(Asignatura asignatura) {
        this.em.merge(asignatura);
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public List<Asignatura> consultarPorNivel(Integer nivel) {
        TypedQuery<Asignatura> query = this.em.createQuery("")
        Query.setParameter("nivel", nivel);

        return query.getResultList();
    }

    @Override
    public List<Asignatura> buscarPorNombreContiene(String texto) {
        this.
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreContiene'");
    }

    @Override
    public Long contarTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarTotal'");
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
