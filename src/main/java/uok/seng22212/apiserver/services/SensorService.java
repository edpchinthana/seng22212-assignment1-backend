package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorType;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface SensorService {

    void addSensor(List<Sensor> sensor);
    List<Sensor> getSensorsBySensorType(SensorType sensorType) throws ExecutionException, InterruptedException;
    Sensor getSensorById(String id) throws ExecutionException, InterruptedException;
    void updateSensor(Sensor sensor);


}
