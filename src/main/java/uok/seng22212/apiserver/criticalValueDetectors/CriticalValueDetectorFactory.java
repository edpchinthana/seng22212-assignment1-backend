package uok.seng22212.apiserver.criticalValueDetectors;

import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.models.SensorData;

@Service
public class CriticalValueDetectorFactory {
    public CriticalValueDetector getInstance(SensorData sensorData){
        CriticalValueDetector criticalValueDetector = null;
        switch (sensorData.getType()){
            case TEMPERATURE:
                criticalValueDetector = new TemperatureCriticalValueDetector();
                break;
        }

        return criticalValueDetector;
    }
}
