package uce.edu.ec.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Pedido;
import uce.edu.ec.domain.respository.PedidoRepository;

@ApplicationScoped
public class PedidoService {

    @Inject
    private PedidoRepository pedidoRepository;

    public void guardar(Pedido pedido) {
        this.pedidoRepository.crear(pedido);
    }

    public Pedido buscarPorId(Integer id) {
        return this.pedidoRepository.seleccionarPorId(id);
    }

    public void actualizar(Pedido pedido) {
        this.pedidoRepository.actualizar(pedido);
    }

    public void eliminar(Integer id) {
        this.pedidoRepository.eliminar(id);
    }

    public List<Pedido> buscarTodos() {
        return this.pedidoRepository.seleccionarTodos();
    }
}