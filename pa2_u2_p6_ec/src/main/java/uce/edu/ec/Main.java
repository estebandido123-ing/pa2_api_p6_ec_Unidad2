package uce.edu.ec;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.application.service.AlumnoService;
import uce.edu.ec.application.service.MateriaService;
import uce.edu.ec.domain.model.Alumno;
import uce.edu.ec.domain.model.Materia;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        

        @Inject
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRES!");
            System.out.println(" PRUEBAS DE RELACIÓN @ManyToMany: Alumno-Materia");
/* 
            System.out.println("1. Creando Materias...");
            Materia materia1 = new Materia();
            materia1.setNombre("Ingeniería de Software");
            materia1.setNumeroCreditos(4);

            Materia materia2 = new Materia();
            materia2.setNombre("Inteligencia Artificial");
            materia2.setNumeroCreditos(3);

            List <Materia> listaMaterias = List.of(materia1,materia2);

            System.out.println("-> Guardando materias en la base de datos...");
            materiaService.guardar(materia1);
            materiaService.guardar(materia2);
            System.out.println(" Materias guardadas.");

            // 2. Crear y guardar al Alumno
            System.out.println("\n2. Creando Alumno...");
            Alumno alumnoNuevo = new Alumno();
            alumnoNuevo.setNombre("Esteban Chachalo");

            System.out.println("-> Guardando alumno en la base de datos...");
            alumnoService.guardar(alumnoNuevo);
            System.out.println(" Alumno guardado con ID: " + alumnoNuevo.getId());

             
            // 3. Vincular y Actualizar (Aquí ocurre la magia del @JoinTable)
            System.out.println("\n3. Matriculando al alumno en las materias...");
            
            // Le pasamos la lista de materias al alumno
            alumnoNuevo.setMaterias(Arrays.asList(materia1, materia2));

            System.out.println("-> Actualizando alumno para generar la tabla intermedia...");
            // Al actualizar, Hibernate detecta la lista y hace los INSERT en 'alumno_materia'
            alumnoService.actualizar(alumnoNuevo);

            System.out.println(" Relación Muchos a Muchos completada con éxito.");

            System.out.println("\n==========================================");
            System.out.println(" PRUEBA @ManyToMany FINALIZADA");
            System.out.println("==========================================\n");
*/
            

            System.out.println("Conexion a la base de datos POSTGRES!");
            System.out.println("\n==========================================");
            System.out.println(" PRUEBAS DE RELACIÓN @ManyToMany: Alumno-Materia");
            System.out.println("==========================================\n");

            System.out.println("1. Creando y guardando Materias...");
            Materia materia3 = new Materia();
            materia3.setNombre("Ingeniería de Software");
            materia3.setNumeroCreditos(4);

            Materia materia4 = new Materia();
            materia4.setNombre("Progra");
            materia4.setNumeroCreditos(6);

            materiaService.guardar(materia3);
            materiaService.guardar(materia4);
            System.out.println(" Materias guardadas con IDs: " + materia3.getId() + " y " + materia4.getId());

            System.out.println("\n2. Creando y guardando Alumnos...");
            Alumno alumnoNuevo3 = new Alumno();
            alumnoNuevo3.setNombre("Diego");
            alumnoService.guardar(alumnoNuevo3); // ¡Guardamos a Diego!

            Alumno alumnoNuevo4 = new Alumno();
            alumnoNuevo4.setNombre("Esteban Chachalo");
            alumnoService.guardar(alumnoNuevo4); 
            System.out.println(" Alumnos guardados con IDs: " + alumnoNuevo3.getId() + " y " + alumnoNuevo4.getId());


            System.out.println("\n3. Matriculando a los alumnos en las materias...");
            
            alumnoNuevo3.setMaterias(java.util.Arrays.asList(materia3, materia4));
            alumnoNuevo4.setMaterias(java.util.Arrays.asList(materia3));

            materia3.setAlumnos(java.util.Arrays.asList(alumnoNuevo3, alumnoNuevo4));
            materia4.setAlumnos(java.util.Arrays.asList(alumnoNuevo3));

            System.out.println("-> Actualizando alumnos para llenar la tabla intermedia...");
            alumnoService.actualizar(alumnoNuevo3);
            alumnoService.actualizar(alumnoNuevo4);
            System.out.println(" Relación Muchos a Muchos completada con éxito.");


            
            System.out.println(" REPORTE: ALUMNOS POR MATERIA");

            java.util.List<Integer> idsMaterias = java.util.Arrays.asList(materia3.getId(), materia4.getId());

            for (Integer idMat : idsMaterias) {
                Materia mat = materiaService.buscarPorIdConAlumnos(idMat);
                
                System.out.println("\n MATERIA: " + mat.getNombre() + " (Créditos: " + mat.getNumeroCreditos() + ")");
                
                if (mat.getAlumnos() != null && !mat.getAlumnos().isEmpty()) {
                    for (Alumno al : mat.getAlumnos()) {
                        System.out.println("  Alumno inscrito: " + al.getNombre() + " (ID: " + al.getId() + ")");
                    }
                } else {
                    System.out.println("  No hay alumnos matriculados en esta materia.");
                }
                System.out.println("------------------------------------------");
            }


            // =========================================================
            // 5. CONSULTA INDIVIDUAL: ALUMNO POR ID Y SUS MATERIAS
            // =========================================================
            System.out.println("\n==========================================");
            System.out.println(" EJECUTANDO CONSULTA POR ID DE ALUMNO");
            System.out.println("==========================================\n");

            // Busquemos a Diego para ver qué materias tiene
            Integer idAlumnoABuscar = alumnoNuevo3.getId(); 
            System.out.println("-> Buscando al alumno con ID: " + idAlumnoABuscar);

            Alumno alumnoEncontrado = alumnoService.buscarPorIdConMaterias(idAlumnoABuscar);

            if (alumnoEncontrado != null) {
                System.out.println(" Alumno encontrado: " + alumnoEncontrado.getNombre());
                
                System.out.println("\n--- Materias asignadas a este alumno ---");
                if (alumnoEncontrado.getMaterias() != null && !alumnoEncontrado.getMaterias().isEmpty()) {
                    alumnoEncontrado.getMaterias().forEach(materia -> {
                        System.out.println("- Materia: " + materia.getNombre() 
                                           + " | Créditos: " + materia.getNumeroCreditos() 
                                           + " (ID: " + materia.getId() + ")");
                    });
                } else {
                    System.out.println("El alumno no se encuentra matriculado en ninguna materia actualmente.");
                }
            } else {
                System.out.println(" No se encontró ningún alumno con el ID especificado.");
            }

            System.out.println("\n==========================================");
            
            





             Quarkus.waitForExit();
            return 0;        
        }
    }
}