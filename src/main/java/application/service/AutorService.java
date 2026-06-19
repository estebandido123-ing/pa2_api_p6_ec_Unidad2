package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Autor;
import Domain.repository.AutorRepository;

@ApplicationScoped
public class AutorService {
    @Inject private AutorRepository autorRepository;

    public void guardar(Autor autor) { this.autorRepository.crear(autor); }
    public Autor buscarPorId(Integer id) { return this.autorRepository.seleccionarPorId(id); }
    public void actualizar(Autor autor) { this.autorRepository.actualizar(autor); }
    public void eliminar(Integer id) { this.autorRepository.eliminar(id); }
    public List<Autor> buscarTodos() { return this.autorRepository.seleccionarTodos(); }
}
