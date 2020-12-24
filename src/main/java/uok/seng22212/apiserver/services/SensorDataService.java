package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;

import java.util.List;


public interface SensorDataService {

    void addSensorData(SensorType sensorType, SensorData sensorData);
    List<SensorData> getAllSensorData();
    List<SensorData> getSensorDataByType(String type, String from, String to);
}

