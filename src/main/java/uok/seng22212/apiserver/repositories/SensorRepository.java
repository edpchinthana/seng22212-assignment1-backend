package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.Sensor;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SensorRepository {
    List<Sensor> getSensors();
    Sensor getSensorById(String id) throws ExecutionException, InterruptedException;
    void addSensor(Sensor sensor);
}
