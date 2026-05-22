package uce.edu.pa2.api.Deber6;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.pa2.api.Deber6.application.service.ProfesorService;
import uce.edu.pa2.api.Deber6.domain.model.Profesor;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        
        @Inject
        private ProfesorService profesorService;
        

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a base de datos");


            //Estudiante estudiante =  new Estudiante(12, "Esteban", "Chachalo", 19012003, "masculino");
            

            System.out.println("\n==========================================");
            System.out.println(" INICIANDO PRUEBAS CRUD - PROFESOR");
            System.out.println("==========================================");

            // 1. CREATE (Crear un nuevo profesor)
            Profesor nuevoProfesor = new Profesor();
            nuevoProfesor.setNombre("Marta");
            nuevoProfesor.setApellido("Ruiz");
            nuevoProfesor.setTitulo("Magister");
            nuevoProfesor.setDepartamento("Matematicas");
            profesorService.guardar(nuevoProfesor);
            System.out.println("[CREATE] Nuevo profesor guardado en la BD.");

            // 2. READ (Leer el profesor que se creó en el import.sql con ID 1)
            Profesor profesorLeido = profesorService.buscarXId(1);
            if (profesorLeido != null) {
                System.out.println("[READ] Profesor encontrado: " + profesorLeido.getNombre() + " - " + profesorLeido.getTitulo());
                
                // 3. UPDATE (Subirle el título al profesor leído)
                profesorLeido.setTitulo("Doctor (PhD)");
                profesorService.actualizar(profesorLeido);
                System.out.println("[UPDATE] Titulo del profesor actualizado a: " + profesorLeido.getTitulo());
                
                // 4. DELETE (Eliminar el profesor con ID 1)
                profesorService.eliminar(1);
                System.out.println("[DELETE] Profesor con ID 1 eliminado de la BD.");
            } else {
                System.out.println("[ERROR] No se encontro el profesor con ID 1.");
            }

            System.out.println("==========================================");
            System.out.println(" PRUEBAS FINALIZADAS CON EXITO");
            System.out.println("==========================================\n");




            return 0;        
        }
    }
}
