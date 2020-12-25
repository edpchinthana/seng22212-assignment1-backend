package uok.seng22212.apiserver.alertSystem;

import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.SensorData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AlertSystem {

    void sendAlert(SensorData sensorData) throws Exception;
    List<Alert> getAlertHistory() throws ExecutionException, InterruptedException;
}
