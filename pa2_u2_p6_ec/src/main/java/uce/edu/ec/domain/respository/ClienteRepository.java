package uce.edu.ec.domain.respository;

import java.util.List;

import uce.edu.ec.domain.model.Cliente;

public interface ClienteRepository {
    
    void crear(Cliente cliente);
    
    Cliente seleccionarPorId(Integer id);
    
    void actualizar(Cliente cliente);
    
    void eliminar(Integer id);
    
    List<Cliente> seleccionarTodos();
    
}