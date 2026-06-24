import Application.service.CuentaBancariaService;
import Application.service.TransferenciaService;
import Domain.model.CuentaBancaria;
import Domain.model.Transferencia;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;


@QuarkusMain
public class Main {
    
    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {
        
        @Inject
        private CuentaBancariaService cuentaBancariaService;

        @Inject
        private TransferenciaService transferenciaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRES!");


            // 1. Crear y guardar la Cuenta Bancaria 
            System.out.println("1. Creando Cuenta Bancaria");
            CuentaBancaria cuentaNueva = new CuentaBancaria();
            cuentaNueva.setPropietario("Esteban Chachalo");
            cuentaNueva.setNumeroCuenta("1020304050");
            cuentaNueva.setSaldo(500.00);

            CuentaBancaria cuentaDestino = new CuentaBancaria();
            cuentaDestino.setId(null);
            cuentaDestino.setPropietario("Carla");
            cuentaDestino.setNumeroCuenta("1712345678");
            cuentaDestino.setSaldo(30.0);

            System.out.println(" Guardando Cuentas en la base de datos");
            cuentaBancariaService.guardar(cuentaNueva);
            cuentaBancariaService.guardar(cuentaDestino);
            System.out.println(" Cuenta guardada con ID: " + cuentaNueva.getId());
            System.out.println(" Cuenta guardada con ID: " + cuentaDestino.getId());

            // 2. Crear las Transferencias
            System.out.println("\n2. Creando Transferencias");
            Transferencia trans1 = new Transferencia();
            trans1.setMonto(45.50);
            trans1.setDescripcion("Pago de servicios básicos");
            
            Transferencia trans2 = new Transferencia();
            trans2.setMonto(120.00);
            trans2.setDescripcion("Compra de víveres supermercado");

            // 3. Vincular las transferencias a la cuenta bancaria recién guardada
            System.out.println("-> Vinculando las transferencias a la cuenta...");
            trans1.setCuentaOrigen(cuentaNueva);
            trans1.setCuentaDestino(cuentaDestino);

            trans2.setCuentaOrigen(cuentaNueva);
            trans2.setCuentaDestino(cuentaDestino);

            // 4. Guardar las transferencias en la base de datos
            System.out.println(" Guardando Transferencias en la base de datos");
            transferenciaService.guardar(trans1);
            transferenciaService.guardar(trans2);
            System.out.println(" Transferencias guardadas con éxito.");

            // 4.5. Actualizar saldo de la cuenta destino aplicando la transferencia recibida
            System.out.println("\n-> Procesando acreditación contable");
            cuentaBancariaService.acreditarMonto(cuentaDestino.getId(), trans1.getMonto());
            cuentaBancariaService.acreditarMonto(cuentaDestino.getId(), trans2.getMonto());


            cuentaBancariaService.debitarMonto(cuentaNueva.getId(), trans1.getMonto());
            cuentaBancariaService.debitarMonto(cuentaNueva.getId(), trans2.getMonto());

            //Actualizando ambas cuentas bancarias
            CuentaBancaria destinoActualizada = cuentaBancariaService.buscarPorId(cuentaDestino.getId());
            CuentaBancaria origenActualizada = cuentaBancariaService.buscarPorId(cuentaNueva.getId());


            // 5. Mostrar reporte básico para verificar en consola
            System.out.println("\n-------------------------------------------");
            System.out.println(" REPORTE DE OPERACIONES");
            System.out.println("---------------------------------------------");
            System.out.println("Número de Cuenta: " + cuentaNueva.getNumeroCuenta());
            System.out.println("Propietario de la cuenta: " + cuentaNueva.getPropietario());
            System.out.println("Saldo Inicial: $" + cuentaNueva.getSaldo());
            System.out.println("Transacciones registradas:");
            System.out.println(" - " + trans1.getDescripcion() + " | Monto: " + trans1.getMonto());
            System.out.println(" - " + trans2.getDescripcion() + " | Monto: " + trans2.getMonto());
            System.err.println("Numero de cuenta destino: " + cuentaDestino.getNumeroCuenta());
            System.out.println("Propietario de la cuenta: " + cuentaDestino.getPropietario()); 
            System.out.println("Saldo Final en cuenta destino: $" + (destinoActualizada != null ? destinoActualizada.getSaldo() : cuentaDestino.getSaldo()));
            System.out.println("Saldo origen final: $" + (origenActualizada != null ? origenActualizada.getSaldo() : cuentaNueva.getSaldo()));
            System.out.println("---------------------------------------------\n");

            Quarkus.waitForExit();
            return 0;        
        }
    }
}