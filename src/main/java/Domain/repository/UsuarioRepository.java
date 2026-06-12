package Domain.repository;

import Domain.model.Usuario;

public interface UsuarioRepository {
    void crear(Usuario usuario);
    Usuario seleccionarPorId(Integer id);
    void actualizar(Usuario usuario);
    void eliminar(Integer id);
}
