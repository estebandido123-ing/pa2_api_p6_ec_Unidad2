package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Libro;
import Domain.repository.LibroRepository;

@ApplicationScoped
public class LibroService {
    @Inject private LibroRepository libroRepository;

    public void guardar(Libro libro) { this.libroRepository.crear(libro); }
    public Libro buscarPorId(Integer id) { return this.libroRepository.seleccionarPorId(id); }
    public void actualizar(Libro libro) { this.libroRepository.actualizar(libro); }
    public void eliminar(Integer id) { this.libroRepository.eliminar(id); }
    public List<Libro> buscarTodos() { return this.libroRepository.seleccionarTodos(); }
}
