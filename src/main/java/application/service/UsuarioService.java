package application.service;
import Domain.model.Usuario;
import Domain.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public void guardar(Usuario usuario) { this.usuarioRepository.crear(usuario); }
    public Usuario buscarPorId(Integer id) { return this.usuarioRepository.seleccionarPorId(id); }
    public void actualizar(Usuario usuario) { this.usuarioRepository.actualizar(usuario); }
    public void eliminar(Integer id) { this.usuarioRepository.eliminar(id); }
}