package uok.seng22212.apiserver.criticalValueDetectors;

import uok.seng22212.apiserver.models.SensorData;

public class TemperatureCriticalValueDetector implements CriticalValueDetector{

    @Override
    public boolean detect(SensorData sensorData) {
        return (sensorData.getDataValue()>sensorData.getThreshold());
    }
}
