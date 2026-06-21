package Domain.model;

import java.util.List;
import jakarta.persistence.CascadeType;
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
@Table(name= "proyecto")
public class Proyecto {

    @Id
    @SequenceGenerator(name = "seq_proyecto", sequenceName = "seq_proyecto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_proyecto")
    @Column(name = "proy_id")
    private Integer id;

    @Column(name = "proy_nombre")
    private String nombre;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name= "proyecto_desarrollador", 
        joinColumns= @JoinColumn(name = "prod_id_proyecto"), 
        inverseJoinColumns= @JoinColumn(name= "prod_id_desarrollador")
    )
    private List<Desarrollador> desarrolladores;

    public Proyecto() {}

    public Proyecto(String nombre) {
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

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }
}
