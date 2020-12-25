package uok.seng22212.apiserver.repositories;

import uok.seng22212.apiserver.models.SensorCategory;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SensorCategoryRepository {

    List<SensorCategory> getAllCategories() throws ExecutionException, InterruptedException;
    void AddCategory(SensorCategory sensorCategory);
}
