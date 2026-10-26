public class Fase3_Experimentos {
    public static void main(String[] args) {
        System.out.println("--Inicio Fase 3--");
        System.out.println("Experimento A");
        {
            SensorTemperatura temp = new SensorTemperatura();
            Thread hilo = new Thread(temp, "sensor-Temp-ExpA");
            hilo.start();
            System.out.println("Informe inmediato (vacío o incompleto): " + temp.informe());
            try {
                hilo.join();
            } catch (InterruptedException e) {}
            System.out.println("Informe tras esperar: " + temp.informe() + "\n");
        }

        System.out.println("Experimento B");
        {
            ProgramadorRiego riegoSecuencial = new ProgramadorRiego();
            long ini = System.currentTimeMillis();
            riegoSecuencial.run();
            long fin = System.currentTimeMillis();

            System.out.println("Tiempo gastado llamando a run(): " + (fin - ini) + " ms");
            System.out.println("Estado del hilo riegoSecuencial.getState(): " + riegoSecuencial.getState() + "\n");
        }

        System.out.println("Experimento C");
        {
            ProgramadorRiego riegoDoble = new ProgramadorRiego();
            riegoDoble.start();
            try {
                riegoDoble.join();
                riegoDoble.start();
            } catch (IllegalThreadStateException e) {
                System.out.println("Excepción: " + e.getClass().getName());
                System.out.println("terminado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
