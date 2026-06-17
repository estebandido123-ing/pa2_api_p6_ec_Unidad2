import java.time.LocalDateTime;

import Domain.model.Carrito;
import Domain.model.Usuario;
import application.service.CarritoService;
import application.service.UsuarioService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;



@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        
        @Inject
        private UsuarioService usuarioService;

        @Inject
        private CarritoService carritoService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRES!");

            System.out.println("\n==========================================");
            System.out.println(" PRUEBA DE E-COMMERCE Y CASCADE MERGE");
            System.out.println("==========================================\n");

            Usuario miUsuario = new Usuario();
            miUsuario.setNombre("Carlos Andres");
            miUsuario.setEmail("carlos@gmail.com");

            System.out.println("-> Guardando Usuario inicial...");
            usuarioService.guardar(miUsuario);

            Carrito miCarrito = new Carrito();
            miCarrito.setTotal(350.75);
            miCarrito.setFechaCreacion(LocalDateTime.now());

            System.out.println("-> Vinculando Usuario y Carrito...");
            miCarrito.setUsuario(miUsuario); 
            miUsuario.setCarrito(miCarrito);  

            System.out.println("-> Guardando el carrito en la base de datos...");
            carritoService.guardar(miCarrito);
            
            System.out.println("✅ Guardados con éxito.");

            System.out.println("\n-> Probando CascadeType.MERGE...");
            
            miCarrito.setTotal(500.00); 
            miCarrito.getUsuario().setEmail("nuevo_correo@gmail.com"); 

            carritoService.actualizar(miCarrito);

            System.out.println("✅ Actualización en Cascada (MERGE) completada.");
            
          
            Usuario usuarioActualizado = usuarioService.buscarPorId(miUsuario.getId());
            System.out.println("El nuevo correo guardado en el usuario es: " + usuarioActualizado.getEmail());

            System.out.println("\n==========================================");


            Quarkus.waitForExit();
            return 0;        
        }
    }
}
