package uok.seng22212.apiserver.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.controllers.SensorController;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetector;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetectorFactory;
import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorType;

import uok.seng22212.apiserver.repositories.SensorRepository;
import uok.seng22212.apiserver.services.SensorService;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class SensorServiceImpl implements SensorService{

    @Autowired
    private SensorRepository repository;


    @Override
    public Sensor getSensorById(String id) throws ExecutionException, InterruptedException {
        try{
            return repository.getSensorById(id);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void addSensor( List<Sensor> sensorList) {
        for(Sensor sensor: sensorList){
            sensor.setId(UUID.randomUUID().toString());
        }
        repository.addSensor(sensorList);
    }

    @Override
    public List<Sensor> getSensorsBySensorType(SensorType sensorType) throws ExecutionException, InterruptedException {
        try{
            return repository.getSensorsBySensorType(sensorType);
        }catch (Exception e){
            throw e;
        }
    }


}
