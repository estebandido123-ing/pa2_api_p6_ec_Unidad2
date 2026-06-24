package Domain.repository;

import java.util.List;

import Domain.model.CuentaBancaria;


public interface CuentaBancariaRepository {
    void crear(CuentaBancaria cuentaBancaria);
    CuentaBancaria seleccionarPorId(Integer id);
    void actualizar(CuentaBancaria cuentaBancaria);
    void eliminar(Integer id);
    List<CuentaBancaria> seleccionarTodos();
}
