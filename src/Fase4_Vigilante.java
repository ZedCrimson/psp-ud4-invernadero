public class Fase4_Vigilante {
    public static void main(String[] args) {
        System.out.println("--Inicio Fase 4--");

        SensorTemperatura temperatura = new SensorTemperatura();
        SensorHumedad humedad = new SensorHumedad();
        SensorLuz luz = new SensorLuz();
        ProgramadorRiego riego = new ProgramadorRiego();

        Thread tTemp = new Thread(temperatura, "sensor-Temperatura");
        Thread tHum = new Thread(humedad, "sensor-Humedad");
        Thread tLuz = new Thread(luz, "sensor-Luz");

        System.out.println("\nEstados Iniciales:");
        System.out.println("tTemp: " + tTemp.getState());
        System.out.println("tHum: " + tHum.getState());
        System.out.println("tLuz: " + tLuz.getState());
        System.out.println("riego: " + riego.getState());

        Thread vigilante = new Thread(() -> {
            while (true) {
                System.out.printf("Vigilante Estados -> Temp: %s | Hum: %s | Luz: %s | Riego: %s%n",
                        tTemp.getState(), tHum.getState(), tLuz.getState(), riego.getState());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "hilo-vigilante");

        vigilante.setDaemon(true);
        vigilante.start();

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

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        System.out.println("\nEstados Finales:");
        System.out.println("tTemp: " + tTemp.getState());
        System.out.println("tHum: " + tHum.getState());
        System.out.println("tLuz: " + tLuz.getState());
        System.out.println("riego: " + riego.getState());
        System.out.println("Fin");
    }
}
