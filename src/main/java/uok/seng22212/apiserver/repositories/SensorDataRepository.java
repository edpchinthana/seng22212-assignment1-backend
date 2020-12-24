package uok.seng22212.apiserver.repositories;

import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;

import java.util.List;


public interface SensorDataRepository {
    void addSensorData(SensorType sensorType, List<SensorData> sensorData);
}
