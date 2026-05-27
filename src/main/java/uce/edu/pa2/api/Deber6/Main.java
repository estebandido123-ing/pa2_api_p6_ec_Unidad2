package uce.edu.pa2.api.Deber6;

import java.util.List;

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

            // ==========================================
            // PRUEBAS PROFESOR
            // ==========================================
            Profesor profesor = new Profesor();
            profesor.setCedula("1711223344");
            profesor.setNombre("Carlos");
            profesor.setApellido("Vera");
            profesor.setTitulo("Magister en Sistemas");
            profesor.setDepartamento("Ciencias de la Computacion");
            System.out.println("Guardando: " + profesor.getNombre());
            profesorService.guardar(profesor);


            // --- LECTURAS Y LISTAS (PROFESOR) ---
            System.out.println("\n--- LISTA DE TODOS LOS PROFESORES ---");
            List<Profesor> todosLosProfesores = profesorService.seleccionarTodos();
            for (Profesor prof : todosLosProfesores) {
                System.out.println("ID: " + prof.getId() + " | Cedula: " + prof.getCedula() + " | Nombre: " + prof.getNombre() + " " + prof.getApellido());
            }
            System.out.println("--------------------------------------\n");
            
            System.out.println("\n--- BUSCAR UN SOLO PROFESOR POR NOMBRE ---");
            try {
                Profesor profUnico = profesorService.selectByNombre("Carlos");
                System.out.println(" Se encontro a: " + profUnico.getNombre() + " " + profUnico.getApellido());
            } catch (Exception e) {
                System.out.println(" Ocurrio un error al buscar por nombre.");
            }

            System.out.println("\n--- BUSCAR TODOS LOS PROFESORES POR NOMBRE (LISTA) ---");
            List<Profesor> listaProfPorNombre = profesorService.seleccionarXNombre("Carlos");
            if (listaProfPorNombre.isEmpty()) {
                System.out.println("No se encontraron profesores con ese nombre.");
            } else {
                for (Profesor prof : listaProfPorNombre) {
                    System.out.println("Encontrado: " + prof.getNombre() + " " + prof.getApellido());
                }
            }

            System.out.println("\n--- BUSCAR PROFESOR POR CEDULA ---");
            try {
                Profesor profCedula = profesorService.seleccionarXCedula("1711223344");
                System.out.println(" Profesor encontrado por cedula: " + profCedula.getNombre());
                
                // Aprovechamos que lo encontramos para probar la actualizacion
                profCedula.setTitulo("Doctor (PhD)");
                profesorService.actualizar(profCedula);
                System.out.println(" Titulo actualizado a: " + profCedula.getTitulo());

            } catch (Exception e) {
                System.out.println(" No se encontro la cedula.");
            }

            

            System.out.println("==========================================");
            System.out.println(" PRUEBAS FINALIZADAS CON EXITO");
            System.out.println("==========================================\n");




            return 0;        
        }
    }
}
