package Domain.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "desarrollador")
public class Desarrollador {

    @Id
    @SequenceGenerator(name = "seq_desarrollador", sequenceName = "seq_desarrollador", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_desarrollador")
    @Column(name = "dev_id")
    private Integer id;

    @Column(name = "dev_nombre")
    private String nombre;

    @Column(name = "dev_lenguaje")
    private String lenguajePrincipal;

    @ManyToMany(mappedBy= "desarrolladores")
    private List<Proyecto> proyectos;

    public Desarrollador() {}

    public Desarrollador(String nombre, String lenguajePrincipal) {
        this.nombre = nombre;
        this.lenguajePrincipal = lenguajePrincipal;
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

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
