package uce.edu.ec.domain.respository;
import java.util.List;

import uce.edu.ec.domain.model.Pedido;

public interface PedidoRepository {
    
    void crear(Pedido pedido);
    
    Pedido seleccionarPorId(Integer id);
    
    void actualizar(Pedido pedido);
    
    void eliminar(Integer id);
    
    List<Pedido> seleccionarTodos();
}