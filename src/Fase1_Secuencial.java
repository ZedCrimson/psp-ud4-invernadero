public class Fase1_Secuencial {
    public static void main(String[] args) {
        System.out.println("--Fase1:Secuancial--");
        long inicio = System.currentTimeMillis();

        Sensor temperatura = new SensorTemperatura();
        Sensor humedad = new SensorHumedad();
        Sensor luz = new SensorLuz();
        ProgramadorRiego riego = new ProgramadorRiego();

        temperatura.run();
        humedad.run();
        luz.run();
        riego.run();

        long fin = System.currentTimeMillis();
        long tiempoTotal = fin - inicio;

        System.out.println("\nInforme final--");
        System.out.println(temperatura.informe());
        System.out.println(humedad.informe());
        System.out.println(luz.informe());
        System.out.println(riego.informe());
        System.out.println("Tiempo total : " + tiempoTotal + " ms");

    }
}
