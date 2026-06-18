package uce.edu.ec;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.application.service.CiudadanoService;
import uce.edu.ec.application.service.EmpleadoService;
import uce.edu.ec.application.service.PedidoService;
import uce.edu.ec.domain.model.Ciudadano;
import uce.edu.ec.domain.model.Cliente;
import uce.edu.ec.domain.model.Empleado;
import uce.edu.ec.domain.model.Pedido;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        

        @Inject
        private CiudadanoService ciudadanoService;

        @Inject
        private EmpleadoService empleadoService;

        @Inject
        private PedidoService pedidoService;



        @Override
        public int run(String... args) throws Exception {

             System.out.println("Conexion a la base de datos POSTGRES!");


            System.out.println(" INICIANDO PRUEBAS - RELACIÓN BIDIRECCIONAL");
            

            Ciudadano ciudadanoNuevo = new Ciudadano();
            ciudadanoNuevo.setNombre("Luis Mideros");
            ciudadanoNuevo.setFechaNacimiento(LocalDate.of(1990, 5, 15));

            Empleado empleadoNuevo = new Empleado();
            empleadoNuevo.setSalario(150.0);
            empleadoNuevo.setFechaIngreso(LocalDateTime.now());

            System.out.println("-> Vinculando el Ciudadano y el Empleado mutuamente...");
            empleadoNuevo.setCiudadano(ciudadanoNuevo); 
            ciudadanoNuevo.setEmpleado(empleadoNuevo);  

            System.out.println("-> Guardando en la base de datos...");
            
            ciudadanoService.guardar(ciudadanoNuevo);
            System.out.println(" Ciudadano guardado con ID: " + ciudadanoNuevo.getId());

            
            empleadoService.guardar(empleadoNuevo);
            System.out.println(" Empleado guardado con ID: " + empleadoNuevo.getId());

            System.out.println("\n==========================================");
            System.out.println(" PRUEBA FINALIZADA CON ÉXITO");
            System.out.println("==========================================\n");

            // DELETE: Eliminar (Opcional, coméntalo si quieres que se quede guardado en tu BD para verlo)
            // System.out.println("\n8. Eliminando al Empleado...");
            // empleadoService.eliminar(empleadoEncontrado.getId());
            // System.out.println(" Empleado eliminado.");
            

            

            //Una transaccion es un conjunto de instrucciones, que se ejecuta 
            // de manera completa, o no se ejecuta ninguna de las transacciones
            

            System.out.println("\n==========================================");
            System.out.println(" PRUEBAS DE RELACIÓN @OneToMany (1 a N)");
            System.out.println("==========================================\n");

            System.out.println("1. Creando al Cliente...");
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setCedula("1750000001");
            nuevoCliente.setNombre("Esteban Chachalo");

            Pedido pedido1 = new Pedido();
            pedido1.setTotal(Double.valueOf(10));
            pedido1.setCliente(nuevoCliente);
            pedido1.setFecha(LocalDate.of(2003, 01, 19));
            
            Pedido pedido2 = new Pedido();
            pedido2.setTotal(Double.valueOf(10));
            pedido2.setCliente(nuevoCliente);
            pedido2.setFecha(LocalDate.of(2003, 01, 19));
            
            
            System.out.println("-> Asignando los pedidos al cliente...");
            pedido1.setCliente(nuevoCliente);
            pedido2.setCliente(nuevoCliente);

            System.out.println("-> Guardando Pedidos en la base de datos...");
            pedidoService.guardar(pedido1);
            pedidoService.guardar(pedido2);

            System.out.println(" PRUEBA @OneToMany FINALIZADA");
            

             Quarkus.waitForExit();
            return 0;        
        }
    }
}