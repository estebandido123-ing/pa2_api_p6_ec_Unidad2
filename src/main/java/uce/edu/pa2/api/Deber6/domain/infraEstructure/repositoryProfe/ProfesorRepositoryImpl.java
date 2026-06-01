package uce.edu.pa2.api.Deber6.domain.infraEstructure.repositoryProfe;
import java.time.LocalDate;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }   

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {        
        this.em.remove(this.seleccionarPorId(id));
    }

    @Override
    public Profesor seleccionarPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return query.getResultList();
    }

    @Override
     public List<Profesor> seleccionarPorNombre(String nombre) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre1 ", Profesor.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorCedula(String cedula) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula1 ", Profesor.class);
        miQuery.setParameter("cedula1", cedula);
        return miQuery.getResultList().getLast(); // Mantenemos tu uso de getLast()
    }

    // 1.2 NamedQuery
    @Override
    public List<Profesor> seleccionarPorDepartamento(String departamento) {
        Query miQuery = this.em.createNamedQuery("Profesor.buscarPorDepartamento");
        miQuery.setParameter("departamento", departamento);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorDepartamentoTyped(String departamento) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.buscarPorDepartamento", Profesor.class);
        miQuery.setParameter("departamento", departamento);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.buscarPorRangoFecha", Profesor.class);
        miQuery.setParameter("fechaInicio", fechaInicio);
        miQuery.setParameter("fechaFin", fechaFin);
        return miQuery.getResultList();
    }

    @Override
    public Long contar() {
       TypedQuery<Long> contar = this.em.createNamedQuery("Profesor.contar", Long.class);
       return contar.getSingleResult();
    }
}
