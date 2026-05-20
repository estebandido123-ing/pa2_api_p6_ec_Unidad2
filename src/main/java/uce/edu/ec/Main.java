package uce.edu.ec;

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

            System.out.println("Conexion a base de datos");

            return 0;        
        }
    }
}