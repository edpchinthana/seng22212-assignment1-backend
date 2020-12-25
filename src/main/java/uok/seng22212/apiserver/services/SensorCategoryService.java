package uok.seng22212.apiserver.services;

import uok.seng22212.apiserver.models.SensorCategory;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SensorCategoryService {
    List<SensorCategory> getAllSensorCategories() throws ExecutionException, InterruptedException;
    void addSensorCategory(SensorCategory sensorCategory);
}
