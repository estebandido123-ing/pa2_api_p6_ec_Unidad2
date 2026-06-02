package uce.edu.ec.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
/*reconoce a la clase Estudiante como una entidad de la base de datos */
@Entity
//especifica el nombre de la tabla en la base de datos a la que se asignará esta entidad
@Table(name = "estudiante")
//se le da un alias a este JPQL(en este caso select Estudiante), y se lo puede llamar por ese alias, dando un solo nombre a nivel de entidad.
//se le asigna un nombre a esta consulta, y se le asigna 
// una consulta JPQL, que es una consulta orientada a 
// objetos, es decir, se consulta a la entidad Estudiante,
//  y se le asigna un parámetro llamado genero, 
// que se lo puede usar en el código para buscar por género
//Para uno
//@NamedQuery(name = "Estudiante.buscarPorGenero", query = "SELECT e FROM Estudiante e WHERE e.genero = :genero")
//@NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
//Para varios NamedQuery se usa la anotación @NamedQueries, que es un contenedor de varios NamedQuery
@NamedQueries({
    @NamedQuery(name = "Estudiante.buscarPorGenero", query = "SELECT e FROM Estudiante e WHERE e.genero = :genero"),
    @NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiante.buscarPorRangoFecha", query = "SELECT e FROM Estudiante e WHERE e.fechaNacimiento BETWEEN :fechaInicio AND :fechaFin"),
    @NamedQuery(name = "Estudiante.contar", query = "SELECT COUNT(e) FROM Estudiante e")
    
})
public class Estudiante {
//cada atributo de la clase representa una columna en la tabla de la base de datos
    // dice a que columna de la tabla se asignará el atributo id, en este caso a la columna "id"
    //puede ser un prefijo que identifica a la tabla "estu_id"
    //Esta atada a una secuencia de la base de datos, es decir, el valor del id se genera automáticamente por la base de datos  
    @SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_estudiante_generador")
    @Id
    @Column(name = "estu_id")    
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;
    
    @Column(name = "estu_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "estu_genero")
    private String genero;

    @Column(name = "estu_cedula" , unique = true , nullable = false)
    private String cedula;

    public Estudiante(){

    }

    public Estudiante(String apellido, String cedula, LocalDate fechaNacimiento, String genero, Integer id, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", genero=" + genero + ", cedula=" + cedula + "]";
    }

    

    

}
