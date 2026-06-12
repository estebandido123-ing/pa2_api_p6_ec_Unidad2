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

            System.out.println("\n==========================================");
            System.out.println(" INICIANDO PRUEBAS");
            System.out.println("==========================================\n");

            System.out.println("1. Registrando nuevo Usuario...");
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsername("dev_master");
            nuevoUsuario.setEmail("dev@correo.com");
            
            usuarioService.guardar(nuevoUsuario);
            System.out.println("✅ Usuario guardado exitosamente: " + nuevoUsuario);

            System.out.println("\n2. Creando Carrito de compras...");
            Carrito nuevoCarrito = new Carrito();
            nuevoCarrito.setTotalPagar(150.75);
            nuevoCarrito.setFechaCreacion(LocalDateTime.now());
            
            
            System.out.println("3. Asignando el carrito al usuario...");
            nuevoCarrito.setUsuario(nuevoUsuario);

            System.out.println("4. Guardando el Carrito en la base de datos...");
            carritoService.guardar(nuevoCarrito);
            System.out.println("✅ Carrito guardado exitosamente: " + nuevoCarrito);


            Quarkus.waitForExit();
            return 0;        
        }
    }
}
