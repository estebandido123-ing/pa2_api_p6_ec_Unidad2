package Application.service;

import java.util.List;

import Domain.model.CuentaBancaria;
import Domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class CuentaBancariaService {

    @Inject
    private CuentaBancariaRepository cuentaBancariaRepository;

    public void guardar(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.crear(cuentaBancaria);
    }

    public CuentaBancaria buscarPorId(Integer id) {
        return this.cuentaBancariaRepository.seleccionarPorId(id);
    }

    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.actualizar(cuentaBancaria);
    }

    public void eliminar(Integer id) {
        this.cuentaBancariaRepository.eliminar(id);
    }

    public List<CuentaBancaria> buscarTodos() {
        return this.cuentaBancariaRepository.seleccionarTodos();
    }

    public void acreditarMonto(Integer idCuentaDestino, Double monto) {
        CuentaBancaria cuentaDestino = this.cuentaBancariaRepository.seleccionarPorId(idCuentaDestino);
        
        if (cuentaDestino != null) {
            Double saldoActual = cuentaDestino.getSaldo();
            Double nuevoSaldo = saldoActual + monto;
            
            cuentaDestino.setSaldo(nuevoSaldo);
            
            this.cuentaBancariaRepository.actualizar(cuentaDestino);

            System.out.println("-> Banco: Cuenta ID " + idCuentaDestino + " acreditada con éxito. Nuevo Saldo: $" + nuevoSaldo);
        } else {
            System.out.println("-> Error: No se encontró la cuenta destino con ID: " + idCuentaDestino);
        }
    }

    public void debitarMonto(Integer idCuentaOrigen, Double monto) {
        CuentaBancaria cuentaOrigen = this.cuentaBancariaRepository.seleccionarPorId(idCuentaOrigen);
        if (cuentaOrigen != null) {
            Double nuevoSaldo = cuentaOrigen.getSaldo() - monto;
            cuentaOrigen.setSaldo(nuevoSaldo);
            this.cuentaBancariaRepository.actualizar(cuentaOrigen);
            System.out.println("-> [Banco] Cuenta ID " + idCuentaOrigen + " debitada con éxito. Nuevo Saldo: $" + nuevoSaldo);
        } else {
            System.out.println("-> [Error] No se encontró la cuenta origen con ID: " + idCuentaOrigen);
        }
    }
}
