package uok.seng22212.apiserver.criticalValueDetectors;

import uok.seng22212.apiserver.models.SensorData;

public interface CriticalValueDetector {
    boolean detect(SensorData sensorData);
}
