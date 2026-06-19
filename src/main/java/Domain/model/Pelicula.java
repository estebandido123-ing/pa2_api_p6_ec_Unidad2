package Domain.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @SequenceGenerator(name = "seq_pelicula_gen", sequenceName = "seq_pelicula", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pelicula_gen")
    @Column(name = "pel_id")
    private Integer id;

    @Column(name = "pel_titulo")
    private String titulo;

    @Column(name = "pel_duracion_minutos")
    private Integer duracionMinutos;

    public Pelicula() {}

    public Pelicula(Integer id, String titulo, Integer duracionMinutos) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }


    
}
