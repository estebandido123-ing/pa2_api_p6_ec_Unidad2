package Domain.repository;

import Domain.model.Carrito;

public interface CarritoRepository {
    void crear(Carrito carrito);
    Carrito seleccionarPorId(Integer id);
    void actualizar(Carrito carrito);
    void eliminar(Integer id);
}