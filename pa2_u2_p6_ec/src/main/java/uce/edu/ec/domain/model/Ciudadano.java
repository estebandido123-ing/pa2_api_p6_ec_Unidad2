package uce.edu.ec.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {

    // 1. Las etiquetas @Id ahora apuntan directamente a la variable "Id"
    @Id
    @SequenceGenerator(name = "seq_ciudadano_generador", sequenceName = "seq_ciudadano", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_ciudadano_generador")
    @Column(name = "ciu_id")
    private Integer Id;

    @Column(name = "ciu_nombre")
    private String Nombre;

    @Column(name = "ciu_fechaNacimiento")
    private LocalDate fechaNacimiento;

    // 2. La relación bidireccional se coloca debajo, separada de las etiquetas @Id
    @OneToOne(mappedBy = "ciudadano")
    private Empleado empleado;

    // Constructores
    public Ciudadano() {
    }

    public Ciudadano(Integer id, String nombre, LocalDate fechaNacimiento) {
        Id = id;
        Nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}