package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.Alert;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AlertRepository {
    void addAlert(Alert alert);
    List<Alert> getAlertHistory(String sensorId) throws ExecutionException, InterruptedException;
}
