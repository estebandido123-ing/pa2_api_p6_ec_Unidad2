package uce.edu.ec.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {



    @Id
    @SequenceGenerator(name = "seq_cliente_generador", sequenceName = "seq_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_cliente_generador")
    
    @Column(name= "pedi_cedula")
    private String Cedula;

    @Column(name = "pedi_id")
    private Integer Id;

    @Column(name = "pedi_Nombre")
    private String Nombre;

    @OneToMany(mappedBy= "cliente")
    private List<Pedido> pedidos;

    
    public Cliente() {
    }

    public Cliente(String cedula, Integer id, String nombre) {
        Cedula = cedula;
        Id = id;
        Nombre = nombre;
    }




    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    

}
