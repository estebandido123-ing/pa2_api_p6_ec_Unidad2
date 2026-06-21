import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import Domain.model.Desarrollador;
import Domain.model.Proyecto;
import application.service.DesarrolladorService;
import application.service.ProyectoService;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        
        @Inject private ProyectoService proyectoService;
        @Inject private DesarrolladorService desarrolladorService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println(" TALLER: CASCADE Y FETCH (Proyecto-Dev)");

            //Instanciamos los objetos 
            System.out.println("1. Creando Proyecto y Desarrolladores");
            Proyecto proyectoWeb = new Proyecto("Sistema de Votaciones");
            
            Desarrollador dev1 = new Desarrollador("Esteban", "Java / Quarkus");
            Desarrollador dev2 = new Desarrollador("Diego", "React / Frontend");

            // la relación
            proyectoWeb.setDesarrolladores(java.util.Arrays.asList(dev1, dev2));

            
            System.out.println("2. Guardando SOLO el proyecto Cascade actuando");
            proyectoService.guardar(proyectoWeb);
            System.out.println("Proyecto guardado y desarrolladores persistidos automáticamente.");

            
            System.out.println("\n3. Consultando con FETCH");
            Integer idProyectoGenerado = proyectoWeb.getId();
            
            Proyecto proyectoEncontrado = proyectoService.buscarPorIdConDesarrolladores(idProyectoGenerado);

            System.out.println("\nPROYECTO: " + proyectoEncontrado.getNombre());
            System.out.println("Equipo Asignado:");
            for (Desarrollador d : proyectoEncontrado.getDesarrolladores()) {
                System.out.println(" - " + d.getNombre() + " (Especialidad: " + d.getLenguajePrincipal() + ")");
            }

            System.out.println("\n==========================================");
            Quarkus.waitForExit();
            return 0;        
        }
    }
}