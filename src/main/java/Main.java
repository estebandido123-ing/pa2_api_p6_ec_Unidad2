

import java.time.LocalDate;
import java.util.List;

import domain.model.Asignatura;
import domain.model.Auditoria;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        
        @Override
        public int run(String... args) throws Exception {

             System.out.println("=========================================");
            System.out.println("INICIANDO EVALUACION FINAL 1 - E. CHACHALO");
            System.out.println("=========================================\n");

            Asignatura a1 = new Asignatura("PRG2", "Programacion Avanzada II", 4, 3, LocalDate.now());
            Asignatura a2 = new Asignatura("BDD1", "Bases de Datos I", 3, 4, LocalDate.now());
            Asignatura a3 = new Asignatura("PRG1", "Programacion Web", 4, 3, LocalDate.now());
            asignaturaService.guardar(a1);
            asignaturaService.guardar(a2);
            asignaturaService.guardar(a3);

         
            
            System.out.println(">>> CAPTURA 1: Consultar asignaturas por nivel (Nivel 4)");
            List<Asignatura> asigNivel4 = asignaturaService.consultarPorNivel(4);
            asigNivel4.forEach(System.out::println);
            System.out.println("--------------------------------------------------\n");

            System.out.println(">>> CAPTURA 2: Buscar asignaturas cuyo nombre contenga ('Programacion')");
            List<Asignatura> asigTexto = asignaturaService.buscarPorNombreContiene("Programacion");
            asigTexto.forEach(System.out::println);
            System.out.println("--------------------------------------------------\n");

            System.out.println(">>> CAPTURA 3: Contar el numero total de asignaturas registradas");
            Long totalAsignaturas = asignaturaService.contarTotal();
            System.out.println("Total Asignaturas en Base de Datos: " + totalAsignaturas);
            System.out.println("--------------------------------------------------\n");


       
            
            System.out.println(">>> CAPTURA 4: Creacion de un Estudiante con pista de auditoria");
            Estudiante estudiante = new Estudiante();
            estudiante.setCedula("1700000001");
            estudiante.setNombre("Esteban");
            estudiante.setApellido("Chachalo");
            estudianteService.guardar(estudiante); 
            imprimirUltimaAuditoria();
            System.out.println("--------------------------------------------------\n");

            System.out.println(">>> CAPTURA 5: Actualizacion de un Estudiante con pista de auditoria");
            estudiante.setNombre("Esteban Modificado");
            estudianteService.actualizar(estudiante); 
            imprimirUltimaAuditoria();
            System.out.println("--------------------------------------------------\n");

            System.out.println(">>> CAPTURA 6: Eliminacion de un Estudiante con pista de auditoria");
            estudianteService.eliminar(estudiante.getId()); 
            imprimirUltimaAuditoria();
            System.out.println("--------------------------------------------------\n");

            Quarkus.waitForExit();
            return 0;
        }

        
        private void imprimirUltimaAuditoria() {
            try {
                Auditoria ultima = em.createQuery("SELECT a FROM Auditoria a ORDER BY a.id DESC", Auditoria.class)
                                     .setMaxResults(1)
                                     .getSingleResult();
                System.out.println("[AUDITORIA INTERCEPTADA]: " + ultima.toString());
            } catch (Exception e) {
                System.out.println("No se encontro registro de auditoria.");
            }     
        }
    }
}