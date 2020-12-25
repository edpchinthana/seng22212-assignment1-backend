package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.Alert;

import java.util.List;

public interface AlertRepository {
    void addAlert(Alert alert);
    List<Alert> getAlertHistory();
}
