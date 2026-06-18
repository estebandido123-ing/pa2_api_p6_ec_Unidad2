package uce.edu.ec.application.service;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Cliente;
import uce.edu.ec.domain.respository.ClienteRepository;


@ApplicationScoped
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public void guardar(Cliente cliente) {
        this.clienteRepository.crear(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        return this.clienteRepository.seleccionarPorId(id);
    }

    public void actualizar(Cliente cliente) {
        this.clienteRepository.actualizar(cliente);
    }

    public void eliminar(Integer id) {
        this.clienteRepository.eliminar(id);
    }

    public List<Cliente> buscarTodos() {
        return this.clienteRepository.seleccionarTodos();
    }
}