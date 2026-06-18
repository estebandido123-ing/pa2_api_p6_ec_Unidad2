package uce.edu.ec.domain.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name = "seq_pedido_generador", sequenceName = "seq_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_pedido_generador")
    

    @Column(name= "pedi_id")
    private Integer Id;

    @Column(name= "pedi_total")
    private Double total;

    @Column(name= "pedi_fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cli_id")
    private List<Pedido> pedidos;

    @ManyToOne 
    @JoinColumn(name = "cli_id") 
    private Cliente cliente;

    public Cliente getCliente() { 
        return cliente; 
    }
    
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }


    
    public Pedido() {
    }

    public Pedido(Integer id, Double total, LocalDate fecha) {
        Id = id;
        this.total = total;
        this.fecha = fecha;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    

}
