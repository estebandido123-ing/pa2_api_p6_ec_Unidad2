package application.service;

import Domain.model.Carrito;
import Domain.repository.CarritoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class CarritoService {
    @Inject
    private CarritoRepository carritoRepository;

    public void guardar(Carrito carrito) { this.carritoRepository.crear(carrito); }
    public Carrito buscarPorId(Integer id) { return this.carritoRepository.seleccionarPorId(id); }
    public void actualizar(Carrito carrito) { this.carritoRepository.actualizar(carrito); }
    public void eliminar(Integer id) { this.carritoRepository.eliminar(id); }
}