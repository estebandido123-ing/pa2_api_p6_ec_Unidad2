package uce.edu.pa2.api.Deber6.domain.infraEstructure.repositoryProfe;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;
import uce.edu.pa2.api.Deber6.domain.repository.ProfesorRepository;
import jakarta.persistence.criteria.Predicate;

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
        
        List<Profesor> resultados = miQuery.getResultList();
        
        if (resultados.isEmpty()) {
            return null; 
        } else {
            return resultados.getLast(); 
        }
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

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarTodosNative() {
      Query query = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
      return query.getResultList();
    }

    // Criteria API query
    @Override
    public List<Profesor> seleccionarTodosCriteria() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> miQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = miQuery.from(Profesor.class);
        miQuery.select(root);
        TypedQuery<Profesor> query = this.em.createQuery(miQuery);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> miQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = miQuery.from(Profesor.class);
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        miQuery.select(root).where(p1);
        TypedQuery<Profesor> query = this.em.createQuery(miQuery);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarDinamicoCriteria(String nombre, String apellido) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> miQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = miQuery.from(Profesor.class);
        
        List<Predicate> condiciones =  new ArrayList<>();

        if(nombre != null){
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }
        if(apellido != null){
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }
        miQuery.select(root).where(condiciones.toArray(new Predicate[0])); // Aseguramos que se pase como arreglo

        TypedQuery<Profesor> query = this.em.createQuery(miQuery);
        return query.getResultList();    
    }
}
