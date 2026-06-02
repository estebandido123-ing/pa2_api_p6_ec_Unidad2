package uce.edu.ec.domain.Infraestructure.Repository;

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
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Estudiante;
import uce.edu.ec.domain.respository.estudianteRepository;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements estudianteRepository {


    //la clase emtityManagerhace es el principal que gestiona e implementa ORM gestionar todos los accesos de datos (CRUD)
    @Inject
    private EntityManager em;

    //persist es guardar en la base de datos, 
    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }   

    //debe tener un dato primaria en la base de datos para el uso del merge 
    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante);

    }

    //para el metodo eliminar usamos el metodo seleccionar por id
    @Override
    public void eliminar(Integer id) {        
        this.em.remove(this.seleccionarPorId(id));
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        return this.em.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        //JPQL es el lenguaje de consultas orientada a objetos,
        //no se trabaj con columnas ni tablas, se trabaja
        // con esto trabajamos clases y atributos
        TypedQuery<Estudiante> query = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return query.getResultList();
    }
    @Override
     public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre1 ", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula1 ", Estudiante.class);
        miQuery.setParameter("cedula1", cedula);
        
        List<Estudiante> resultados = miQuery.getResultList();
        
        // Verificamos si la lista está vacía ANTES de intentar sacar algo
        if (resultados.isEmpty()) {
            return null; // O podrías lanzar una excepción personalizada
        } else {
            return resultados.getLast(); // Solo saca el último si hay al menos uno
        }
    }
    //1.2 NamedQuery
    //se define en la clase entidad, es decir, en la clase que representa 
    // a la tabla de la base de datos, en este caso en la clase Estudiante
    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        Query miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
        miQuery.setParameter("genero", genero);
        //No se garantiza que sea una lista de Estudiantes
        return miQuery.getResultList();
    }

    @Override
    //mejor version evitando warnings, es decir, usando el tipo de dato correcto
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        miQuery.setParameter("genero", genero);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        miQuery.setParameter("fechaInicio", fechaInicio);
        miQuery.setParameter("fechaFin", fechaFin);
        return miQuery.getResultList();
    }

    @Override
    public Long contar() {
       TypedQuery<Long> contar = this.em.createNamedQuery("Estudiante.contar", Long.class);
       return contar.getSingleResult();
    }

    @Override
    //para suprimir los warnings, es decir,
    // como segundo parametro del metodo createNativeQuery
    @SuppressWarnings("unchecked")
    public List<Estudiante> seleccionarTodosNative() {
      Query query = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
      return query.getResultList();
    }

    //Criteria API query
    //me  permite a travez de API provistas

    @Override
    public List<Estudiante> seleccionarTodosCriteria() {
        //crear una instancia de la clase que sera 
        // la encargada de esta construccion
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        //Definir el tipo de objeto que va retornar mi consulta
        CriteriaQuery <Estudiante> miQuery = cb.createQuery(Estudiante.class);
        // se define las entidades del FROM 
        Root <Estudiante> root = miQuery.from(Estudiante.class);
        // defino con que tipo de  SQL voy a trabajar: SLECT
        miQuery.select(root);
        //Hasta aqui terminamos de construir mi query

        //miQuery lo transformmo en un query ejecutable

        TypedQuery <Estudiante> query = this.em.createQuery(miQuery);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery <Estudiante> miQuery = cb.createQuery(Estudiante.class);
        Root <Estudiante> root = miQuery.from(Estudiante.class);
        //se ercibe primero lo que voy a comprar, y en el segundo contra cual voy a comprar
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        //se ponen las condiciones que van dentro de mi where
        miQuery.select(root).where(p1);

        TypedQuery <Estudiante> query = this.em.createQuery(miQuery);


        return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarDinamicoCriteria(String nombre, String apellido) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery <Estudiante> miQuery = cb.createQuery(Estudiante.class);
        Root <Estudiante> root = miQuery.from(Estudiante.class);
        
        List<Predicate> condiciones =  new ArrayList<>();

        if(nombre != null){
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }
        if(apellido != null){
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);

        }
        miQuery.select(root).where(condiciones);

        TypedQuery <Estudiante> query = this.em.createQuery(miQuery);


        return query.getResultList();    
    }

    






}
