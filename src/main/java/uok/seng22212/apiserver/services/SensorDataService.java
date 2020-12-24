package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.SensorData;

import java.util.List;


public interface SensorDataService {

    void addSensorData(SensorData sensorData, String type);
    List<SensorData> getAllSensorData();
    List<SensorData> getSensorDataByType(String type, String from, String to);
}

