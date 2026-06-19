package application.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import Domain.model.Pelicula;
import Domain.repository.PeliculaRepository;

@ApplicationScoped
public class PeliculaService {
    @Inject private PeliculaRepository peliculaRepository;

    public void guardar(Pelicula pelicula) { this.peliculaRepository.crear(pelicula); }
    public Pelicula buscarPorId(Integer id) { return this.peliculaRepository.seleccionarPorId(id); }
    public void actualizar(Pelicula pelicula) { this.peliculaRepository.actualizar(pelicula); }
    public void eliminar(Integer id) { this.peliculaRepository.eliminar(id); }
    public List<Pelicula> buscarTodos() { return this.peliculaRepository.seleccionarTodos(); }
}
