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
            profesor.setNombre("Raul");
            profesor.setApellido("Arroyo");
            profesor.setFechaContratacion(LocalDate.of(2010, 8, 15));
            profesor.setDepartamento("Ciencias de la Computacion");
            profesor.setCedula("17112321344"); // Asegurate de que esta cedula no choque con tu import.sql
            
            // Guardar un nuevo profesor
            System.out.println("Guardando un nuevo Profesor...");
            profesorService.guardar(profesor);

            /* // Eliminar un profesor por ID
            System.out.println("Eliminamos al Profesor por ID");
            profesorService.eliminar(1);
            
            // Metodo Actualizar
            System.out.println("Actualizar los Datos por ID...");
            Profesor profesor2 = this.profesorService.buscarPorId(2);
            if (profesor2 != null) {
                profesor2.setNombre("Carlos");
                profesor2.setApellido("Vera");
                this.profesorService.actualizar(profesor2);
            }

            // Buscar al Profesor por ID
            System.out.println("Buscando Profesor por ID...");
            System.out.println(profesorService.buscarPorId(2).toString());

            // Seleccionar todos los profesores
            System.out.println("Seleccionar todos los profesores...");
            profesorService.buscarTodos().forEach(p -> System.out.println(p.toString()));

            // Seleccionar por nombre
            System.out.println("Seleccionar por nombre...");
            List<Profesor> profesoresPorNombre = profesorService.buscarPorNombre("Raul");
            for (Profesor p : profesoresPorNombre) {
                System.out.println(p);
            }
            */

            // seleccionar por cedula
            System.out.println("Seleccionar por cedula...");
            try {
                Profesor profesorPorCedula = profesorService.buscarPorCedula("17112321344");
                System.out.println(profesorPorCedula);
            } catch (Exception e) {
                System.out.println("No se encontro profesor con esa cedula.");
            }
            
            // 1.2 NamedQuery--------------------------------------------------------------------------------------------------------------
            
            // Seleccionar por departamento
            System.out.println("Seleccionar por departamento...");
            List<Profesor> profesoresPorDepartamento = profesorService.buscarPorDepartamento("Ciencias de la Computacion");
            for (Profesor p : profesoresPorDepartamento) {
                System.out.println(p);
            }

            // Seleccionar por departamento usando NamedQuery Typed
            System.out.println("Seleccionar por departamento usando NamedQuery Typed...");  
            List<Profesor> profesPorDepartamentoTyped = profesorService.buscarPorDepartamentoTyped("Ciencias de la Computacion");
            for (Profesor p : profesPorDepartamentoTyped) {
                System.out.println(p);
            }
            
            // Seleccionar por rango de fecha usando NamedQuery
            System.out.println("Seleccionar por rango de fecha usando NamedQuery...");  
            List<Profesor> profesoresPorRangoFecha = profesorService.buscarPorRangoFecha(LocalDate.of(2005, 1, 1), LocalDate.of(2015, 12, 31));
            for (Profesor p : profesoresPorRangoFecha) {
                System.out.println(p);
            }

            // Contar el numero de profesores usando NamedQuery
            System.out.println("Contar el numero de profesores usando NamedQuery...");
            Long totalProfesores = profesorService.contar();
            System.out.println("Total de profesores: " + totalProfesores);
            
            Quarkus.waitForExit();
            return 0;        
        }
    }
}
