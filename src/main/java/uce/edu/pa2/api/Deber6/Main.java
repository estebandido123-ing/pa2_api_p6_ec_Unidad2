package uce.edu.pa2.api.Deber6;

import java.time.LocalDate;
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

            System.out.println("Conexion a la base de datos POSTGRES!");
            
            // Creacion de un nuevo Profesor
            Profesor profesor = new Profesor();
            profesor.setNombre("Carlos");
            profesor.setApellido("Vera");
            profesor.setFechaContratacion(LocalDate.of(2015, 5, 10));
            profesor.setDepartamento("Sistemas");
            profesor.setCedula("1711223344"); 
            
            System.out.println("Guardando un nuevo Profesor...");
            profesorService.guardar(profesor);

            // seleccionar por cedula
            System.out.println("Seleccionar por cedula...");
            Profesor profesorPorCedula = profesorService.buscarPorCedula("1711223344");
            System.out.println(profesorPorCedula);
            
            // 1.2 NamedQuery--------------------------------------------------------------------------------------------------------------
            // Seleccionar por departamento
            System.out.println("Seleccionar por departamento...");
            List<Profesor> profesPorDepartamento = profesorService.buscarPorDepartamento("Sistemas");
            for (Profesor p : profesPorDepartamento) {
                System.out.println(p);
            }

            // Seleccionar por departamento usando NamedQuery
            System.out.println("Seleccionar por departamento usando NamedQuery...");  
            List<Profesor> profesPorDepartamentoTyped = profesorService.buscarPorDepartamentoTyped("Sistemas");
            for (Profesor p : profesPorDepartamentoTyped) {
                System.out.println(p);
            }
            
            // Seleccionar por rango de fecha usando NamedQuery
            System.out.println("Seleccionar por rango de fecha usando NamedQuery...");  
            List<Profesor> profesPorRangoFecha = profesorService.buscarPorRangoFecha(LocalDate.of(2010, 1, 1), LocalDate.of(2020, 12, 31));
            for (Profesor p : profesPorRangoFecha) {
                System.out.println(p);
            }
            
            // Contar el numero de profesores usando NamedQuery
            System.out.println("Contar el numero de profesores usando NamedQuery...");
            Long totalProfesores = profesorService.contar();
            System.out.println("Total de profesores: " + totalProfesores);
            
            // Seleccionar todos usando Native Query
            System.out.println("Seleccionar todos los profesores usando Native Query...");
            List<Profesor> profesTodosNative = profesorService.buscarTodosNative();
            for (Profesor p : profesTodosNative) {
                System.out.println(p);
            }

            // Seleccionar todos usando Native Query Criteria
            System.out.println("Seleccionar todos los profesores usando Native Query Criteria...");
            List<Profesor> profesTodosCriteria = profesorService.buscarTodosCriteria();
            for (Profesor p : profesTodosCriteria) {
                System.out.println(p);
            }

            System.out.println("Seleccionar profesores por nombre usando Criteria...");
            List<Profesor> profesPorNombreCriteria = profesorService.buscarPorNombreCriteria("Carlos");
            for (Profesor p : profesPorNombreCriteria) {
                System.out.println(p);
            }

            System.out.println("\n--- PRUEBAS CRITERIA API DINÁMICO ---");

            // Prueba 1: Buscando usando AMBOS campos
            System.out.println("1. Buscando por Nombre 'Carlos' y Apellido 'Vera':");
            List<Profesor> busqueda1 = profesorService.buscarDinamicoCriteria("Carlos", "Vera");
            busqueda1.forEach(System.out::println);

            // Prueba 2: Buscando SOLO por Nombre (Apellido null)
            System.out.println("\n2. Buscando solo por Nombre 'Carlos' (Apellido null):");
            List<Profesor> busqueda2 = profesorService.buscarDinamicoCriteria("Carlos", null);
            busqueda2.forEach(System.out::println);

            // Prueba 3: Buscando SOLO por Apellido (Nombre null)
            System.out.println("\n3. Buscando solo por Apellido 'Vera' (Nombre null):");
            List<Profesor> busqueda3 = profesorService.buscarDinamicoCriteria(null, "Vera");
            busqueda3.forEach(System.out::println);

            // Prueba 4: Buscando con ambos nulos
            System.out.println("\n4. Buscando con ambos nulos (deberia traer todos):");
            List<Profesor> busqueda4 = profesorService.buscarDinamicoCriteria(null, null);
            busqueda4.forEach(System.out::println);

            Quarkus.waitForExit();
            return 0;        
        }
    }
}
