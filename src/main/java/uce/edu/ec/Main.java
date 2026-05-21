package uce.edu.ec;

import java.time.LocalDate;

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
                estudiante.setNombre("Esteban");
                estudiante.setGenero("Masculino");
                estudiante.setFechaNacimiento(LocalDate.of(2000, 1, 19));
                System.out.println(estudiante);
                estudianteService.guardar(estudiante);

                estudianteService.buscarXId( 12);
                estudianteService.actualizar(estudiante);
                estudianteService.eliminar(12);




            return 0;        
        }
    }
}