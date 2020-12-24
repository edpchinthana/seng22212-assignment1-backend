package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorType;

import java.util.List;



public interface SensorService {

    void addSensor(SensorType sensorType, List<Sensor> sensor);
    List<Sensor> getSensor();



}
