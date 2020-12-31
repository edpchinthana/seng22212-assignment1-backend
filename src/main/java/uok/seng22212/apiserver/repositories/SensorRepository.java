package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorType;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SensorRepository {
    Sensor getSensorById(String id) throws ExecutionException, InterruptedException;
    List<Sensor> getSensorsBySensorType(SensorType sensorType) throws InterruptedException, ExecutionException;
    void addSensor(List<Sensor> sensorList);
    void updateSensor(Sensor sensor);
}
