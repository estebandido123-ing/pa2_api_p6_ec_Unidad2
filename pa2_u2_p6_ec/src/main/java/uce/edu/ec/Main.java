package uce.edu.ec;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.application.service.estudianteService;
import uce.edu.ec.domain.model.Estudiante;

@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        

        @Inject
        private estudianteService estudianteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a base de datos");


            //Estudiante estudiante =  new Estudiante(12, "Esteban", "Chachalo", 19012003, "masculino");
            
            
            Estudiante estudiante = new Estudiante();
                estudiante.setCedula("1798765432");
                estudiante.setNombre("Esteban");
                estudiante.setGenero("Masculino");
                estudiante.setFechaNacimiento(LocalDate.of(2000, 1, 19));
                System.out.println(estudiante);
                estudianteService.guardar(estudiante);

                estudianteService.buscarXId( 12);
                estudianteService.actualizar(estudiante);
                estudianteService.eliminar(12);


                System.out.println("\n--- LISTA DE TODOS LOS ESTUDIANTES ---");

                List<Estudiante> todosLosEstudiantes = estudianteService.seleccionarTodos();

                for (Estudiante est : todosLosEstudiantes) {
                System.out.println("ID: " + est.getId() + " | Nombre: " + est.getNombre() + " " + est.getApellido());
            
                    }

                System.out.println("--------------------------------------\n");
                
                System.out.println("\n--- BUSCAR UN SOLO ESTUDIANTE POR NOMBRE ---");
                try {
                    Estudiante estUnico = estudianteService.selectByNombre("Esteban");
                    System.out.println(" Se encontró exactamente a: " + estUnico.getNombre() + " " + estUnico.getApellido());
                } catch (Exception e) {
                    System.out.println(" Ocurrió un error: No existe el estudiante, o hay más de uno con ese nombre.");
                }

                System.out.println("\n--- BUSCAR TODOS LOS ESTUDIANTES POR NOMBRE (LISTA) ---");
                List<Estudiante> listaPorNombre = estudianteService.seleccionarXNombre("Esteban");
                
                if (listaPorNombre.isEmpty()) {
                    System.out.println("No se encontraron estudiantes con ese nombre.");
                } else {
                    for (Estudiante est : listaPorNombre) {
                        System.out.println("ID: " + est.getId() + " | Nombre: " + est.getNombre() + " " + est.getApellido());
                    }
                }

                System.out.println("\n--- BUSCAR ESTUDIANTE POR CÉDULA ---");
                try {
                    Estudiante estEncontrado = estudianteService.seleccionarXCedula("1712345678");
                    System.out.println(" Estudiante encontrado: " + estEncontrado.getNombre() + " " + estEncontrado.getApellido());
                } catch (Exception e) {
                    System.out.println(" No se encontró ningún estudiante con esa cédula.");
                }

                



            return 0;        
        }
    }
}