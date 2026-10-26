import java.util.concurrent.ThreadLocalRandom;

class SensorHumedad extends Sensor {
    public SensorHumedad() {
        super("Humedad", "%", 600, 5, 50.0, 80.0);
    }
    @Override
    public double medir() {
        return ThreadLocalRandom.current().nextDouble(40.0, 90.0);
    }
}
