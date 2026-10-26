import java.util.concurrent.ThreadLocalRandom;

class SensorLuz extends Sensor {
    public SensorLuz() {
        super("Luz", "lux", 500, 5, 200.0, 900.0);
    }
    @Override
    public double medir() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1000.0);
    }
}