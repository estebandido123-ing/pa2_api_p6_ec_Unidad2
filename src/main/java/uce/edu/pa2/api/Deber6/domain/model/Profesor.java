package uce.edu.pa2.api.Deber6.domain.model;

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

@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.buscarPorDepartamento", query = "SELECT p FROM Profesor p WHERE p.departamento = :departamento"),
    @NamedQuery(name = "Profesor.buscarPorApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesor.buscarPorRangoFecha", query = "SELECT p FROM Profesor p WHERE p.fechaContratacion BETWEEN :fechaInicio AND :fechaFin"),
    @NamedQuery(name = "Profesor.contar", query = "SELECT COUNT(p) FROM Profesor p")
})
public class Profesor {

    @SequenceGenerator(name = "seq_profesor_generador", sequenceName = "seq_profesor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generador")
    @Id
    @Column(name = "prof_id")    
    private Integer id;

    @Column(name = "prof_nombre")
    private String nombre;

    @Column(name = "prof_apellido")
    private String apellido;
    
    @Column(name = "prof_fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "prof_departamento")
    private String departamento;

    @Column(name = "prof_cedula", unique = true, nullable = false)
    private String cedula;

    public Profesor() {
    }

    public Profesor(String apellido, String cedula, LocalDate fechaContratacion, String departamento, Integer id, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaContratacion = fechaContratacion;
        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaContratacion() {
        return this.fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaContratacion="
                + fechaContratacion + ", departamento=" + departamento + ", cedula=" + cedula + "]";
    }
}
