package Domain.repository;

import java.util.List;

import Domain.model.Actor;

public interface ActorRepository {
    void crear(Actor actor);
    Actor seleccionarPorId(Integer id);
    void actualizar(Actor actor);
    void eliminar(Integer id);
    List<Actor> seleccionarTodos();
}
