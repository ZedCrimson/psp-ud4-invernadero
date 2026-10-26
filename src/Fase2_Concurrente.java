public class Fase2_Concurrente {
    public static void main(String[] args) {
            System.out.println("--- Inicio Fase 2 ---");
        long inicio = System.currentTimeMillis();

        Sensor temperatura = new SensorTemperatura();
        Sensor humedad = new SensorHumedad();
        Sensor luz = new SensorLuz();
        ProgramadorRiego riego = new ProgramadorRiego();

        Thread tTemp = new Thread(temperatura, "sensor-Temperatura");
        Thread tHum = new Thread(humedad, "sensor-Humedad");
        Thread tLuz = new Thread(luz, "sensor-Luz");

        tTemp.start();
        tHum.start();
        tLuz.start();
        riego.start();

        try {
            tTemp.join();
            tHum.join();
            tLuz.join();
            riego.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        long tiempoTotal = fin - inicio;

        System.out.println("\n--- Informe Final ---");
        System.out.println(temperatura.informe());
        System.out.println(humedad.informe());
        System.out.println(luz.informe());
        System.out.println(riego.informe());
        System.out.println("Tiempo total transcurrido: " + tiempoTotal + " ms");
    }
}
