package uce.edu.ec.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @SequenceGenerator(name = "seq_materia_generador", sequenceName = "seq_materia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_materia_generador")
    
    @Column(name = "mate_id")
    private Integer Id;

    @Column(name = "mate_nombre")
    private String Nombre;

    @Column(name = "mate_numero_creditos")
    private Integer numeroCreditos;
    

    @ManyToMany(mappedBy= "materias")
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
         return alumnos; 
        }
    public void setAlumnos(List<Alumno> alumnos) {
         this.alumnos = alumnos; 
    }

    public Materia() {
    }

    public Materia(Integer id, String nombre, Integer numeroCreditos) {
        Id = id;
        Nombre = nombre;
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }
    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    

}
