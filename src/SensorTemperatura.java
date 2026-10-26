import java.util.concurrent.ThreadLocalRandom;

class SensorTemperatura extends Sensor {
    public SensorTemperatura() {
        super("Temperatura", "°C", 400, 5, 18.0, 30.0);
    }
    @Override
    public double medir() {
        return ThreadLocalRandom.current().nextDouble(15.0, 35.0);
    }
}
