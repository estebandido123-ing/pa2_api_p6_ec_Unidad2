package uce.edu.ec.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @SequenceGenerator(name = "seq_empleado_generador", sequenceName = "seq_empleado", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_empleado_generador")
    
    @Column(name = "emp_id")
    private Integer Id;

    @Column(name = "emp_salario")
    private double salario;

    @Column(name = "emp_feachaInfreso")
    private LocalDateTime fechaIngreso;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ciu_id")
    private Ciudadano ciudadano;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Empleado() {
    }

    public Empleado(Integer id, double salario, LocalDateTime fechaIngreso, Ciudadano ciudadano) {
        Id = id;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        this.ciudadano = ciudadano;
    }



}
