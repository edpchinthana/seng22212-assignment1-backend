package uok.seng22212.apiserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.models.SensorCategory;
import uok.seng22212.apiserver.repositories.SensorCategoryRepository;
import uok.seng22212.apiserver.services.SensorCategoryService;
import uok.seng22212.apiserver.services.SensorService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class SensorCategoryServiceImpl implements SensorCategoryService {

    @Autowired
    SensorCategoryRepository sensorCategoryRepository;

    @Override
    public List<SensorCategory> getAllSensorCategories() throws ExecutionException, InterruptedException {
        try{
            return sensorCategoryRepository.getAllCategories();
        }catch (Exception e){
            throw e;
        }
    }

}
