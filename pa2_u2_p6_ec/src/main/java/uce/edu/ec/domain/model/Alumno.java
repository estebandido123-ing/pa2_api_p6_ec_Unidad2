package uce.edu.ec.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name= "alumno")
public class Alumno {

    @Id
    @SequenceGenerator(name = "seq_alumno_generador", sequenceName = "seq_alumno", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_alumno_generador")
    
    @Column(name = "alum_id")
    private Integer Id;

    @Column(name = "alum_nombre")
    private String Nombre;

    @ManyToMany
    @JoinTable(name= "alumno_materia", joinColumns= @JoinColumn (name = "alma_id_alumno"), inverseJoinColumns= @JoinColumn(name= "alma_id_materia"))
    private List<Materia> materias;

    
    
    public Alumno() {
    }

    public Alumno(Integer id, String nombre) {
        Id = id;
        Nombre = nombre;
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

    @Override
    public String toString() {
        return "Alumno [Id=" + Id + ", Nombre=" + Nombre + ", getId()=" + getId() + ", getNombre()=" + getNombre()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
}
