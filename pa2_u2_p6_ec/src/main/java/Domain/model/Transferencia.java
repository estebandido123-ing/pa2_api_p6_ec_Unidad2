package Domain.model;

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
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
    @Column(name = "trans_id")
    private Integer id;

    @Column(name = "trans_monto")
    private Double monto;

    @Column(name = "trans_descripcion")
    private String descripcion;

    // Relación: Muchas transferencias pertenecen a una cuenta
    @ManyToOne 
    @JoinColumn(name = "cue_id") 
    private CuentaBancaria cuentaBancaria; 

    // Relación 1: Cuenta que envía el dinero
    @ManyToOne 
    @JoinColumn(name = "cue_id_origen") 
    private CuentaBancaria cuentaOrigen; 

    // Relación 2: Cuenta que recibe el dinero
    @ManyToOne 
    @JoinColumn(name = "cue_id_destino") 
    private CuentaBancaria cuentaDestino;

    public Transferencia() {}

    public Transferencia(Integer id, Double monto, String descripcion) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public CuentaBancaria getCuentaOrigen() {
         return cuentaOrigen; 
        }
    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
         this.cuentaOrigen = cuentaOrigen; 
        }
    
    public CuentaBancaria getCuentaDestino() {
         return cuentaDestino; 
        }
    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
         this.cuentaDestino = cuentaDestino; 
        }
}
