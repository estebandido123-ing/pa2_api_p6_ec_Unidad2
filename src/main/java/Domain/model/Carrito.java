package Domain.model;
import java.time.LocalDateTime;

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
@Table(name = "carrito")
public class Carrito {

    @Id
    @SequenceGenerator(name = "seq_carrito_gen", sequenceName = "seq_carrito", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrito_gen")
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "car_total_pagar")
    private double totalPagar;

    @Column(name = "car_fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Aquí está la magia de la relación 1 a 1
    @OneToOne
    @JoinColumn(name = "usu_id", unique = true) 
    private Usuario usuario;

    public Carrito() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Carrito [id=" + id + ", totalPagar=$" + totalPagar + ", usuario=" + (usuario != null ? usuario.getUsername() : "null") + "]";
    }
}
