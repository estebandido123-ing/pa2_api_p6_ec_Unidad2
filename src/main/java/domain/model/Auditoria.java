package domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditoria_estudiante")
public class Auditoria {

    @Id
    @SequenceGenerator(name = "seq_auditoria", sequenceName = "seq_auditoria", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auditoria")

    private Integer Id;

    private String nombreMetodo;

    @Column(length=1000)
    private String arguments;

    private LocalDateTime fechaHoraEjecucion;
    private Long tiempoEjecucion;

    
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getNombreMetodo() {
        return nombreMetodo;
    }
    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }
    public String getArguments() {
        return arguments;
    }
    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
    public LocalDateTime getFechaHoraEjecucion() {
        return fechaHoraEjecucion;
    }
    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;
    }
    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }
    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }


    public Auditoria(Integer id, String nombreMetodo, String arguments, LocalDateTime fechaHoraEjecucion,
            Long tiempoEjecucion) {
        Id = id;
        this.nombreMetodo = nombreMetodo;
        this.arguments = arguments;
        this.fechaHoraEjecucion = fechaHoraEjecucion;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Auditoria(){

    }
    @Override
    public String toString() {
        return "Auditoria [Id=" + Id + ", nombreMetodo=" + nombreMetodo + ", arguments=" + arguments
                + ", fechaHoraEjecucion=" + fechaHoraEjecucion + ", tiempoEjecucion=" + tiempoEjecucion + ", getId()="
                + getId() + ", getNombreMetodo()=" + getNombreMetodo() + ", getArguments()=" + getArguments()
                + ", getFechaHoraEjecucion()=" + getFechaHoraEjecucion() + ", getClass()=" + getClass()
                + ", getTiempoEjecucion()=" + getTiempoEjecucion() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    

    


    




}
