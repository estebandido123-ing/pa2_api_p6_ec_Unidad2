package Domain.model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @SequenceGenerator(name = "seq_actor_gen", sequenceName = "seq_actor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_actor_gen")
    @Column(name = "act_id")
    private Integer id;

    @Column(name = "act_nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "actor_pelicula", 
        joinColumns = @JoinColumn(name = "act_pel_id_actor"), 
        inverseJoinColumns = @JoinColumn(name = "act_pel_id_pelicula")
    )
    private List<Pelicula> peliculas;

    public Actor() {}

    public Actor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

}