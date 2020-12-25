package uok.seng22212.apiserver.alertSystem;

import uok.seng22212.apiserver.models.SensorData;

public interface AlertSystem {

    void sendAlert(SensorData sensorData);

}
