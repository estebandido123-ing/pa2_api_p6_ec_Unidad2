
import Domain.model.Actor;
import Domain.model.Autor;
import Domain.model.Libro;
import Domain.model.Pelicula;
import application.service.ActorService;
import application.service.AutorService;
import application.service.LibroService;
import application.service.PeliculaService;
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
        private PeliculaService peliculaService;

        @Inject
        private ActorService actorService;

        @Inject
        private AutorService autorService;

        @Inject
        private LibroService libroService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRES!");

            System.out.println("\n==========================================");
            System.out.println(" PRUEBAS DE RELACIÓN @OneToMany: Autor-Libro");
            System.out.println("==========================================\n");

            System.out.println("1. Creando y guardando al Autor...");
            Autor autorNuevo = new Autor();
            autorNuevo.setNombre("Gabriel García Márquez");
            autorNuevo.setNacionalidad("Colombiano");
            
            autorService.guardar(autorNuevo); 
            System.out.println("✅ Autor guardado con ID: " + autorNuevo.getId());

            System.out.println("\n2. Creando Libros...");
            Libro libro1 = new Libro();
            libro1.setTitulo("Cien años de soledad");
            libro1.setPrecio(25.50);
            
            Libro libro2 = new Libro();
            libro2.setTitulo("El amor en los tiempos del cólera");
            libro2.setPrecio(18.99);

            System.out.println("-> Asignando los libros al autor...");
            libro1.setAutor(autorNuevo);
            libro2.setAutor(autorNuevo);

            System.out.println("-> Guardando Libros en la base de datos...");
            libroService.guardar(libro1);
            libroService.guardar(libro2);

            System.out.println("✅ Libros guardados con éxito.");

            System.out.println(" PRUEBA @OneToMany FINALIZADA");
            
            

            System.out.println("\n==========================================");


            Quarkus.waitForExit();
            return 0;        
        }
    }
}