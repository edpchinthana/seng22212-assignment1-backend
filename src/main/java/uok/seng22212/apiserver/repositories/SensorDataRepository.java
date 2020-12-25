package uok.seng22212.apiserver.repositories;

import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;


import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public interface SensorDataRepository {
    void addSensorData(SensorType sensorType, List<SensorData> sensorData);
    List<SensorData> getSensorDataBySensorId(String sensorId, Date from, Date to) throws ExecutionException, InterruptedException;
}
