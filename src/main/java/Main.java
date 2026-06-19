
import Domain.model.Actor;
import Domain.model.Pelicula;
import application.service.ActorService;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRES!");

            // 1. Crear y guardar Películas
            Pelicula p1 = new Pelicula(null, "Matrix", 136);
            Pelicula p2 = new Pelicula(null, "John Wick", 101);
            peliculaService.guardar(p1);
            peliculaService.guardar(p2);

            // 2. Crear y guardar Actor
            Actor actor = new Actor(null, "Keanu Reeves");
            actorService.guardar(actor);

            // 3. Vincular y Actualizar
            actor.setPeliculas(java.util.List.of(p1, p2));
            actorService.actualizar(actor);
            

            System.out.println("\n==========================================");


            Quarkus.waitForExit();
            return 0;        
        }
    }
}