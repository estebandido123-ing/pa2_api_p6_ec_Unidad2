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

             System.out.println("Conexion a la base de datos POSTGRES!");
            
            //Creacion de un nuevo Estudiante
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Esteban");
            estudiante.setApellido("Chachalo");
            estudiante.setFechaNacimiento(LocalDate.of(2003, 1, 19));
            estudiante.setGenero("M");
       /*      
            //Guardar un nuevo estudiante
            System.out.println("Guardando un nuevo Estudiante...");
            estudianteService.guardar(estudiante);

            //Eliminar un estudiante por ID
            System.out.println("Eliminamos al Estudiante por ID");
            estudianteService.eliminar(1);
            
            //Metodo Actualizar
            System.out.println("Actualizar los Datos por ID...");
            Estudiante estudiante2 = this.estudianteService.buscarPorId(3);
            estudiante2.setNombre("Paul");
            estudiante2.setApellido("Gomez");
            this.estudianteService.actualizar(estudiante2);

            //Buscar al Estudiante por ID
            System.out.println("Buscando Estudiante por ID...");
            System.out.println(estudianteService.buscarPorId(2).toString());

            //Seleccionar todos los estudiantes
            System.out.println("Seleccionar todos los estudiantes...");
            estudianteService.buscarTodos().forEach(e -> System.out.println(e.toString()));

            //Seleccionar por nombre
            System.out.println("Seleccionar por nombre...");
            List<Estudiante> estudiantesporNombre = estudianteService.buscarPorNombre("Alex");
            for (Estudiante e : estudiantesporNombre) {
                System.out.println(e);
            }
*/
            //seleccionar por cedula
            System.out.println("Seleccionar por cedula...");
            Estudiante estudianteporCedula = estudianteService.buscarPorCedula("1712345678");
            System.out.println(estudianteporCedula);
            //1.2 NamedQuery--------------------------------------------------------------------------------------------------------------
            //Seleccionar por genero
            System.out.println("Seleccionar por genero...");
            List<Estudiante> estudiantesporGenero = estudianteService.buscarPorGenero("M");
            for (Estudiante e : estudiantesporGenero) {
                System.out.println(e);
            }

            //Seleccionar por genero usando NamedQuery
            System.out.println("Seleccionar por genero usando NamedQuery...");  
            List<Estudiante> estudiantesporGeneroTyped = estudianteService.buscarPorGeneroTyped("M");
            for (Estudiante e : estudiantesporGeneroTyped) {
                System.out.println(e);
            }
            //Seleccionar por rango de fecha usando NamedQuery
            System.out.println("Seleccionar por rango de fecha usando NamedQuery...");  
            List<Estudiante> estudiantesporRangoFecha = estudianteService.buscarPorRangoFecha(LocalDate.of(2004, 1, 1), LocalDate.of(2007, 12, 31));
            for (Estudiante e : estudiantesporRangoFecha) {
                System.out.println(e);
            }
            //Contar el numero de estudiantes usando NamedQuery
            System.out.println("Contar el numero de estudiantes usando NamedQuery...");
            Long totalEstudiantes = estudianteService.contar();
            System.out.println("Total de estudiantes: " + totalEstudiantes);
            
            
            //Seleccionar todos los estudiantes usando Native Query
            System.out.println("Seleccionar todos los estudiantes usando Native Query...");
            List<Estudiante> estudiantesTodosNative = estudianteService.buscarTodosNative();
            for (Estudiante e : estudiantesTodosNative) {
                System.out.println(e);
            }

            //Seleccionar todos los estudiantes usando Native Query Criteria
            System.out.println("Seleccionar todos los estudiantes usando Native Query...");
            List<Estudiante> estudiantesTodosCriteria = estudianteService.buscarTodosCriteria();
            for (Estudiante e : estudiantesTodosCriteria) {
                System.out.println(e);
            }


            System.out.println("Seleccionar todos los estudiantes usando Native Query...");
            List<Estudiante> estudiantesPorNombreCriteria = estudianteService.buscarPorNombreCriteria("Esteban");
            for (Estudiante e : estudiantesPorNombreCriteria) {
                System.out.println(e);
            }

            //necesito que un nombre query se consulte por nombre y apellido, 
            // a menos que uno sea null, que sea un metodo dinamico, que se 
            // contruya el 


            System.out.println("\n--- PRUEBAS CRITERIA API DINÁMICO ---");

            // Prueba 1: Buscando usando AMBOS campos
            System.out.println("1. Buscando por Nombre 'Esteban' y Apellido 'Chachalo':");
            List<Estudiante> busqueda1 = estudianteService.buscarDinamicoCriteria("Esteban", "Chachalo");
            busqueda1.forEach(System.out::println);

            // Prueba 2: Buscando SOLO por Nombre (Apellido va nulo)
            System.out.println("\n2. Buscando solo por Nombre 'Alex' (Apellido null):");
            List<Estudiante> busqueda2 = estudianteService.buscarDinamicoCriteria("Alex", null);
            busqueda2.forEach(System.out::println);

            // Prueba 3: Buscando SOLO por Apellido (Nombre va nulo)
            System.out.println("\n3. Buscando solo por Apellido 'Gomez' (Nombre null):");
            List<Estudiante> busqueda3 = estudianteService.buscarDinamicoCriteria(null, "Gomez");
            busqueda3.forEach(System.out::println);

            System.out.println("\n3. Buscando solo por null:");
            List<Estudiante> busqueda4 = estudianteService.buscarDinamicoCriteria(null, null);
            busqueda3.forEach(System.out::println);

             Quarkus.waitForExit();
            return 0;        
        }
    }
}