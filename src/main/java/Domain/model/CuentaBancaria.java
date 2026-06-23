package Domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

    @Id
    @SequenceGenerator(name = "seq_cuenta", sequenceName = "seq_cuenta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta")
    @Column(name = "cue_id")
    private Integer id;

    @Column(name = "cue_numero")
    private String numeroCuenta;

    @Column(name = "cue_propietario")
    private String Propietario;

    @Column(name = "cue_saldo")
    private Double saldo;

    // Relación: Una cuenta tiene muchas transferencias
    // IMPORTANTE: "cuentaBancaria" es el nombre exacto de la variable en la otra clase
    @OneToMany(mappedBy = "cuentaBancaria")
    private List<Transferencia> transferencias;

    // Mapea el historial de transferencias enviadas desde esta cuenta
    @OneToMany(mappedBy = "cuentaOrigen")
    private List<Transferencia> transferenciasEnviadas;

    // Mapea el historial de transferencias recibidas en esta cuenta
    @OneToMany(mappedBy = "cuentaDestino")
    private List<Transferencia> transferenciasRecibidas;

    public CuentaBancaria() {}

    public CuentaBancaria(Integer id, String numeroCuenta, Double saldo) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public List<Transferencia> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }

    public void setTransferenciasEnviadas(List<Transferencia> transferenciasEnviadas) {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }

    public List<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }

    public void setTransferenciasRecibidas(List<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }
}
