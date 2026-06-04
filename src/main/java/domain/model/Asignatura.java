package domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @SequenceGenerator(name = "seq_asignatura", sequenceName = "seq_asignatura", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_asignatura")
    private Integer Id;

    @Column(unique = true, nullable = false)
    private String codigo;

    private String Nombre;
    private Integer Nivel;
    private Integer NumeroDeCreditos;
    private LocalDate fechaDeCreacion;


    public Asignatura(String string, String string2, int i, int j, LocalDate localDate){

    }


    public Asignatura(Integer id, String codigo, String nombre, Integer nivel, Integer numeroDeCreditos,
            LocalDate fechaDeCreacion) {
        this.Id = id;
        this.codigo = codigo;
        Nombre = nombre;
        Nivel = nivel;
        NumeroDeCreditos = numeroDeCreditos;
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public Integer getNivel() {
        return Nivel;
    }
    public void setNivel(Integer nivel) {
        Nivel = nivel;
    }
    public Integer getNumeroDeCreditos() {
        return NumeroDeCreditos;
    }
    public void setNumeroDeCreditos(Integer numeroDeCreditos) {
        NumeroDeCreditos = numeroDeCreditos;
    }
    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asignatura{");
        sb.append("id=").append(Id);
        sb.append(", codigo=").append(codigo);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Nivel=").append(Nivel);
        sb.append(", NumeroDeCreditos=").append(NumeroDeCreditos);
        sb.append(", fechaDeCreacion=").append(fechaDeCreacion);
        sb.append('}');
        return sb.toString();
    }

    

}
