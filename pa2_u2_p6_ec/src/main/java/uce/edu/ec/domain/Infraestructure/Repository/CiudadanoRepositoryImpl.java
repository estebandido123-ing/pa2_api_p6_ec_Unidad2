package uce.edu.ec.domain.Infraestructure.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Ciudadano;
import uce.edu.ec.domain.respository.CiudadanoRepository;

@ApplicationScoped
@Transactional
public class CiudadanoRepositoryImpl implements CiudadanoRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Ciudadano ciudadano) {
        this.em.persist(ciudadano);
    }

    @Override
    public Ciudadano seleccionarPorId(Integer id) {
        return this.em.find(Ciudadano.class, id);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.em.merge(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        Ciudadano ciudadano = this.seleccionarPorId(id);
        if (ciudadano != null) {
            this.em.remove(ciudadano);
        }
    }
}